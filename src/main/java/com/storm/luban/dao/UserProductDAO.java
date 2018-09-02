package com.storm.luban.dao;

import com.storm.luban.bean.UserProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserProductDAO {
    /**
     *查询用户产品
     * @param
     * @return
     * @author storm
     * @date 2018\8\11 0011 23:00
     */
    List<UserProduct> getUserProduct(@Param("userId") Long userId);

    /**
      * 用户可用商品
      * @param userProducts
      * @return
      * @author storm
      * @date 2018-08-11 23:21:37
     */
    void insertUserProductBatch(@Param("products") List<UserProduct> userProducts);

}
