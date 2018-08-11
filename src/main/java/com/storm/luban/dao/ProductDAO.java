package com.storm.luban.dao;

import com.storm.luban.bean.Product;

import java.util.List;

/**
 * @author storm
 * @Title: ProductDAO
 * @ProjectName luban
 * @date 2018\8\7 000721:32
 */
public interface ProductDAO {

    List<Product> queryProduct();
}
