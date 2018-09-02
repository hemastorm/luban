package com.storm.luban.service.impl;

import com.storm.luban.bean.*;
import com.storm.luban.dao.UserMaterialGroupDAO;
import com.storm.luban.exception.BizException;
import com.storm.luban.exception.SysDataException;
import com.storm.luban.exception.UserMaterialException;
import com.storm.luban.service.MaterialTypeTemplateBO;
import com.storm.luban.service.UserMaterialBO;
import com.storm.luban.vo.UserInfo;
import com.storm.luban.vo.UserMaterialGroupTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserMaterialBOImpl implements UserMaterialBO {
    @Autowired
    private UserMaterialCache userMaterialCache;
    @Autowired
    private MaterialTypeTemplateBO materialTypeTemplateBO;
    @Autowired
    private UserMaterialGroupDAO groupDAO;

    @Override
    @Transactional
    public void initUserBasicData(UserInfo userInfo) {
        intUserMaterialGroup(userInfo);
    }
    private void intUserMaterialGroup(UserInfo userInfo) {
        //只初始化一次后面不需要初始化
        List<UserProduct> userMaterials = userMaterialCache.getUserProduct(userInfo.getUserId());
        if (userMaterials != null && userMaterials.size() > 0) {
            return;
        }
        //初始化product
        List<UserProduct> userProducts = initUserProduct(userInfo);
        for (UserProduct userProduct : userProducts) {
            initUserMaterial(userInfo, userProduct.getId(), null, null);
        }
    }

    private void initUserMaterial(UserInfo userInfo, Long productId, Long sysParentId, Long userParentId) {
        List<MaterialType> sysMaterialType = materialTypeTemplateBO.getSysMaterialType(productId, sysParentId);
        if (sysMaterialType.size() > 0) {
            for (MaterialType materialType : sysMaterialType) {
                UserMaterialGroup group = new UserMaterialGroup();
                group.setUserId(userInfo.getUserId());
                group.setTypeId(materialType.getTypeId());
                group.setProductId(materialType.getProductId());
                group.setName(materialType.getName());
                group.setCode(materialType.getCode());
                group.setParentId(-1L);
                group.setComputeMode(materialType.getComputeMode());
                group.setUnit(materialType.getUnit());
                group.setShortCode(materialType.getShortCode());
                group.setIsSys(1);
                userMaterialCache.insertUserMaterialGroup(userInfo.getUserId(), group);
                if (materialType.getIsLeaf() == 0) {
                    //如果不是叶子节点，则继续执行下去
                    initUserMaterial(userInfo, productId, materialType.getTypeId(), group.getGroupId());
                }
            }
        }
    }

    //初始化product
    private List<UserProduct> initUserProduct(UserInfo userInfo) {
        List<Product> sysProduct = materialTypeTemplateBO.getSysProduct();
        if (sysProduct == null || sysProduct.size() == 0) {
            throw new SysDataException("系统配置商品为空");
        }
        List<UserProduct> userProducts = new ArrayList<>();
        for (Product product : sysProduct) {
            UserProduct userProduct = new UserProduct();
            userProduct.setCode(product.getCode());
            userProduct.setId(product.getId());
            userProduct.setName(product.getName());
            userProduct.setStatus(1);
            userProduct.setUserId(userInfo.getUserId());
            userProducts.add(userProduct);
        }
        userMaterialCache.insertUserProductBatch(userInfo.getUserId(), userProducts);
        return userProducts;
    }

    @Override
    public void addMaterialGroup(UserInfo userInfo, UserMaterialGroup group) throws BizException {
        Long parentId = group.getParentId();
        if (parentId == null) {
            throw new UserMaterialException("添加材料分组父类不可为空");
        }
        if (parentId == -1) {
            //说明是root的子集，前台需要传入所有信息,直接保存
            group.setCreator(userInfo.getAccountName());
            group.setModifier(userInfo.getAccountName());
            group.setIsSys(0);
        } else {
            UserMaterialGroup parentGroup = groupDAO.selectById(parentId);
            group.setUserId(userInfo.getUserId());
            group.setTypeId(parentGroup.getTypeId());
            group.setProductId(parentGroup.getProductId());
            group.setCode(parentGroup.getCode());
            group.setParentId(-1L);
            group.setComputeMode(parentGroup.getComputeMode());
            group.setUnit(parentGroup.getUnit());
            group.setShortCode(parentGroup.getShortCode());
            group.setIsSys(0);
        }
        userMaterialCache.insertUserMaterialGroup(userInfo.getUserId(), group);
    }

    @Override
    public void delMaterialGroup(UserInfo userInfo, Long groupId) throws BizException {
        UserMaterialGroup userMaterialGroup = groupDAO.selectById(groupId);
        if (userMaterialGroup == null) {
            log.info("材料组不存在，不需要删除！");
            throw new UserMaterialException("删除数据不存在，刷新列表重新操作！");
        }
        userMaterialCache.softDelMaterialGroup(userInfo.getUserId(), groupId);
    }

    @Override
    @Cacheable(value = "userPreference",key = "'user_material_group_'+#userId")
    public List<UserMaterialGroupTree> queryMaterialGroup(Long userId, Long productId) throws BizException {
        //从第一级开始逐级查询
        List<UserMaterialGroup> groups = groupDAO.selectUserMaterialGroups(userId, productId, null);
        if (groups == null || groups.size() == 0) {
            log.info("用户没有设置任何的材料数据");
            return null;
        }
        List<UserMaterialGroupTree> groupTrees = new ArrayList<>();
        for (UserMaterialGroup group : groups) {
            UserMaterialGroupTree groupTree = new UserMaterialGroupTree();
            groupTree.setCode(group.getCode());
            groupTree.setIsSys(group.getIsSys());
            groupTree.setGroupId(group.getGroupId().toString());
            groupTree.setName(group.getName());
            groupTree.setParentId(group.getParentId().toString());
            groupTree.setTypeId(group.getTypeId().toString());
            groupTree.setChildren(queryMaterialGroup(userId, productId, group.getGroupId()));
            groupTrees.add(groupTree);
        }
        return groupTrees;
    }


    private List<UserMaterialGroupTree> queryMaterialGroup(Long userId, Long productId, Long parentId) throws BizException {
        List<UserMaterialGroup> groups = groupDAO.selectUserMaterialGroups(userId, productId, parentId);
        if (groups == null || groups.size() == 0) {
            log.info("用户没有设置任何的材料数据");
            return null;
        }
        List<UserMaterialGroupTree> groupTrees = new ArrayList<>();
        for (UserMaterialGroup group : groups) {
            UserMaterialGroupTree groupTree = new UserMaterialGroupTree();
            groupTree.setCode(group.getCode());
            groupTree.setIsSys(group.getIsSys());
            groupTree.setGroupId(group.getGroupId().toString());
            groupTree.setName(group.getName());
            groupTree.setParentId(group.getParentId().toString());
            groupTree.setTypeId(group.getTypeId().toString());
            List<UserMaterialGroupTree> childrenTree = queryMaterialGroup(userId, productId, parentId);
            if (childrenTree != null) {
                groupTree.setChildren(childrenTree);
            }
            groupTrees.add(groupTree);
        }
        return groupTrees;
    }


    @Override
    public void addMaterial(UserInfo userInfo, UserMaterial material) throws BizException {
    }

    @Override
    public List<UserMaterial> queryMaterial(Long userId, Long groupId, int pageIndex, int pageSize) throws BizException {
        return null;
    }
}
