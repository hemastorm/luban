package com.storm.luban.service;

import com.storm.luban.vo.UserInfo;

/**
 * 用户材料服务
 *
 * @author storm
 * @Title: UserMaterialBO
 * @ProjectName luban
 * @date 2018\8\7 000722:18
 */
public interface UserMaterialBO {

    /**
     *首次登录，初始化用户基础数据
     * @author storm
     * @date 2018\8\7 0007 22:22
     * @param
     * @return
     */
    void initUserBasicData(UserInfo userInfo);
}
