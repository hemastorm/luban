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
     * 查询系统初始材料种类
     * @param productId
     * @return
     */
    List<MaterialType> getSysMaterialType(@Param("productId") Long productId);
}
