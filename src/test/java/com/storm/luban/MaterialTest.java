package com.storm.luban;

import com.storm.luban.service.UserMaterialBO;
import com.storm.luban.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
@Slf4j
public class MaterialTest {
    @Autowired
    private UserMaterialBO userMaterialBO;

    @Test
    public void userMaterialInit() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1L);
        userMaterialBO.initUserBasicData(userInfo);
    }
}
