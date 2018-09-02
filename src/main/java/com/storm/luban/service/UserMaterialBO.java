package com.storm.luban.service;

import com.storm.luban.bean.UserMaterialGroup;
import com.storm.luban.exception.BizException;
import com.storm.luban.vo.UserInfo;
import com.storm.luban.vo.UserMaterialGroupTree;

import java.util.List;

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
    
    /** 
      *页面添加一个材料分组
      * @param
      * @return 
      * @author storm
      * @date 2018-08-11 23:41:25
     */
    void addMaterialGroup(UserInfo userInfo, UserMaterialGroup group)throws BizException;
    
    /** 
      *删除某个材料分组
      * @param userInfo
      * @param groupId
      * @return 
      * @author storm
      * @date 2018-08-12 00:01:59
     */
    void delMaterialGroup(UserInfo userInfo,Long groupId)throws BizException;

    /**
     * 级联查询用户所有的分组
     * @param userId
     * @return
     * @author storm
     * @date 2018-08-12 00:03:22
     */
    List<UserMaterialGroupTree> queryMaterialGroup(Long userId, Long productId) throws BizException;

    /** 
     * 添加材料
     * @params  
     * @author storm
     * @date 2018-08-12 00:07:51
     */
    void addMaterial(UserInfo userInfo, UserMaterial material)throws BizException;

    /**
     * 分页查询材料列表
     * @params
     * @return
     * @author storm
     * @date 2018-08-12 00:10:30
     */
    List<UserMaterial> queryMaterial(Long userId,Long groupId,int pageIndex,int pageSize) throws BizException;
}
