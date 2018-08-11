package com.storm.luban.dao;

import com.storm.luban.bean.MaterialAttrTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author storm
 * @ProjectName luban
 * @date 2018\8\6 000622:06
 */
public interface MaterialAttrTemplateDAO {
    /**
     * 材料种类属性
     * @param typeId
     * @return
     */
    List<MaterialAttrTemplate> queryByTypeId(@Param("typeId") Long typeId);
}
