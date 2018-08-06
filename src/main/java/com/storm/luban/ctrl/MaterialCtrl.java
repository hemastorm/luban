package com.storm.luban.ctrl;

import com.storm.luban.bean.MaterialType;
import com.storm.luban.service.MaterialTypeTemplateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class MaterialCtrl {
    @Autowired
    private MaterialTypeTemplateBO templateBO;

    @GetMapping("/getMaterilaType")
    public List<MaterialType> getMaterilaType(){
        return templateBO.getSysMaterialType(1L);
    }
}
