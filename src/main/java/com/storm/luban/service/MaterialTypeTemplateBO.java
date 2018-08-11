package com.storm.luban.service;

import com.storm.luban.bean.MaterialAttrTemplate;
import com.storm.luban.bean.MaterialType;
import com.storm.luban.bean.Product;

import java.util.List;

/**
 * 系统配置的材料信息
 * @author storm
 * @Title: MaterialTypeTemplateBO
 * @ProjectName luban
 * @date 2018\8\5 000523:04
 */
public interface MaterialTypeTemplateBO {

    /**
     * 查询系统配置的所有的材料模板
     * @author storm
     * @date 2018\8\5 0005 23:35
     * @param
     * @return
     */
    List<MaterialType> getSysMaterialType(Long productId);
    
    /** 
     * 查询材料类型的所有属性
     * @author storm
     * @date 2018\8\5 0005 23:34
     * @param  typeId 材料类型ID
     * @return 
     */
    List<MaterialAttrTemplate> getSysMaterialAttr(Long typeId);

    /** 
     * 查询所有的支持的产品
     * @author storm
     * @date 2018\8\7 0007 21:38
     * @param  
     * @return 
     */
    List<Product> getSysProduct();
}
