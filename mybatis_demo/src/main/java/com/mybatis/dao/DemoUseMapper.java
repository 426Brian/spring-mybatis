package com.mybatis.dao;

import com.mybatis.model.DemoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Brian in 20:26 2018/3/16
 */
public interface DemoUseMapper {
//    @Select("select * from demo_user where user_id = #{id}")
    DemoUser getUserById(Integer userId);

    List<DemoUser> getUserList();

    /**
     * mybatis 允许增删改查 直接定义以下类型返回值
     *  1. Integer  Long  Boolean
     *  2. 我们需要手动提交数据
     *      sqlSessionFactory.openSession(); --> 手动提交
     *      sqlSessionFactory.openSession(true); --> 自动提交
     */

    void insertUser(DemoUser user);

    void updateUser(DemoUser user);

    void deleteUser(int userId);

    /*@Param 参数集合中key值指定
    DemoUser getUser(@Param("userId")int userId, @Param("empName")String empName);

    DemoUser getUser(Map<String,  Object> map);


    DemoUser getUser(List<String> list);
    xml文件中Sql 参数取值要用list[0],这样的方式取*/

}
