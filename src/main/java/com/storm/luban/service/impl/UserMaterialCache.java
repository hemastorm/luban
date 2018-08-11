package com.storm.luban.service.impl;

import com.storm.luban.bean.UserMaterial;
import com.storm.luban.bean.UserProduct;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
 * 用户材料相关缓存中间类
 * @author storm
 * @date 2018\8\7 0007 22:30
 */
@Service
public class UserMaterialCache {

    public List<UserMaterial> getUserProduct(Long userId) {
        return null;
    }

    public void insertUserProductBatch(Long userId, List<UserProduct> userProducts) {
    }
}
