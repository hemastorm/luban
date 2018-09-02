package com.storm.luban.dao;

import com.storm.luban.bean.MaterialType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author storm
 * @Title: MaterialTypeDAO
 * @ProjectName luban
 * @date 2018\8\6 000622:05
 */
public interface MaterialTypeDAO {

    /**
     * 查询子类目
     * @author storm
     * @date 2018\8\11 0011 22:13
     * @param
     * @return
     */
    List<MaterialType> querySysMaterialType(@Param("productId") Long productId, @Param("parentId") Long parentId);
}
