package com.storm.luban.service.impl;

import com.storm.luban.bean.Product;
import com.storm.luban.bean.UserMaterial;
import com.storm.luban.bean.UserProduct;
import com.storm.luban.exception.SysDataException;
import com.storm.luban.service.MaterialTypeTemplateBO;
import com.storm.luban.service.UserMaterialBO;
import com.storm.luban.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional
    public void initUserBasicData(UserInfo userInfo) {
        intUserMaterialGroup(userInfo);
    }

    private void intUserMaterialGroup(UserInfo userInfo) {
        //只初始化一次后面不需要初始化
        List<UserMaterial> userMaterials = userMaterialCache.getUserProduct(userInfo.getUserId());
        if (userMaterials != null && userMaterials.size() > 0) {
            return;
        }
        //初始化product
        List<UserProduct> userProducts = initUserProduct(userInfo);

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
            userProduct.setStatue(1);
            userProduct.setUserId(userInfo.getUserId());
            userProducts.add(userProduct);
        }
        userMaterialCache.insertUserProductBatch(userInfo.getUserId(), userProducts);
        return userProducts;
    }


}
