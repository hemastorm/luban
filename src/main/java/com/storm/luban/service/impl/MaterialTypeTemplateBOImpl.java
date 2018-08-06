package com.storm.luban.service.impl;

import com.storm.luban.bean.MaterialAttrTemplate;
import com.storm.luban.bean.MaterialType;
import com.storm.luban.dao.MaterialAttrTemplateDAO;
import com.storm.luban.dao.MaterialTypeDAO;
import com.storm.luban.service.MaterialTypeTemplateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialTypeTemplateBOImpl implements MaterialTypeTemplateBO {
    @Autowired
    private MaterialTypeDAO materialTypeDAO;
    @Autowired
    private MaterialAttrTemplateDAO attrTemplateDAO;
    @Override
    @Cacheable(value = "sysPreference", key = "#root.methodName+'_'+#productId")
    public List<MaterialType> getSysMaterialType(Long productId) {
        return materialTypeDAO.getSysMaterialType(productId);
    }

    @Override
    @Cacheable(value = "sysPreference", key = "#root.methodName+'_'+#typeId")
    public List<MaterialAttrTemplate> getSysMaterialAttr(Long typeId) {
        return null;
    }
}
