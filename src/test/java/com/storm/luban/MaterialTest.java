package com.storm.luban;

import com.storm.luban.bean.MaterialType;
import com.storm.luban.service.MaterialTypeTemplateBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@Slf4j
public class MaterialTest {
    @Autowired
    private MaterialTypeTemplateBO templateBO;
    @Test
    public  void getSysMaterialType(){
        List<MaterialType> sysMaterialType = templateBO.getSysMaterialType(1L);
    }
}
