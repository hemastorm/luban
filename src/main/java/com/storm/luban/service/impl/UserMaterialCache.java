package com.storm.luban.service.impl;

import com.storm.luban.bean.UserMaterialGroup;
import com.storm.luban.bean.UserProduct;
import com.storm.luban.dao.UserMaterialGroupDAO;
import com.storm.luban.dao.UserProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户材料相关缓存中间类
 *
 * @author storm
 * @date 2018\8\7 0007 22:30
 */
@Service
public class UserMaterialCache {
    @Autowired
    private UserMaterialGroupDAO groupDAO;
    @Autowired
    private UserProductDAO productDAO;

    @Cacheable(value = "userPreference", key = "'user_product_'+#userId")
    public List<UserProduct> getUserProduct(Long userId) {
        return productDAO.getUserProduct(userId);
    }
    @CacheEvict(value = "userPreference", key = "'user_product_'+#userId")
    public void insertUserProductBatch(Long userId, List<UserProduct> userProducts) {
        productDAO.insertUserProductBatch(userProducts);
    }
    @CacheEvict(value = "userPreference", key = "'user_material_group_'+#userId")
    public void insertUserMaterialGroup(Long userId, UserMaterialGroup group) {
        groupDAO.insertUserMaterialGroup(group);
    }
    @CacheEvict(value = "userPreference", key = "'user_material_group_'+#userId")
    public void softDelMaterialGroup(Long userId, Long groupId) {
        groupDAO.softDel(groupId);
    }
}
