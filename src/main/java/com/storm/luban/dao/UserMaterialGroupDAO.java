package com.storm.luban.dao;

import com.storm.luban.bean.UserMaterialGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author storm
 * @Title: UserMaterialGroupDAO
 * @ProjectName luban
 * @date 2018\8\7 000722:01
 */
public interface UserMaterialGroupDAO {

    /**
     * 插入用户材料组
     *
     * @param group
     * @return
     * @author storm
     * @date 2018-08-11 23:26:11
     */
    void insertUserMaterialGroup(@Param("group") UserMaterialGroup group);

    /**
     * 主键查询材料组
     *
     * @param
     * @return
     * @author storm
     * @date 2018-08-11 23:56:56
     */
    UserMaterialGroup selectById(@Param("groupId") Long id);

    /**
     * 物理删除材料分组
     *
     * @return
     * @params
     * @author storm
     * @date 2018-08-12 22:33:08
     */
    void softDel(@Param("groupId") Long groupId);
    
    /** 
     * 查询用户分组
     * @params  
     * @return 
     * @author storm
     * @date 2018-08-19 22:43:06
     */
    List<UserMaterialGroup> selectUserMaterialGroups(@Param("userId") Long userId, @Param("productId") Long productId, @Param("parentId") Long parentId);
}
