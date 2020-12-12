package com.itdfq.dormitory.dao;

import com.github.pagehelper.Page;
import com.itdfq.dormitory.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 */
public interface UsersDAO {

    @Select("select * from users where username=#{username} and delFlag=1")
     Users selectByUsername(String username);

    @Select("select * from users  where delFlag=1")
    List<Users> findByPage();
    //条件查询
    @Select("select * from users where realname like concat('%',#{realname},'%') and delFlag=1")
    List<Users> findByTJ(Users users);
    //单选删除
    @Update("update users set delFlag=0 where uid = #{uid}")
    void delete(int uid);
    //插入数据
    @Insert("insert into users(realname,username,password,phone) values(#{realname},#{username},#{password},#{phone})")
    void insert(Users users);
    //更新数据
    @Update("update users set realname=#{realname},username=#{username},password=#{password},phone=#{phone},role=#{role} where uid = #{uid}")
    void update(Users users);
    //多选删除
    @Update({"<script>" +
            " update users set delFlag =0 where uid  in "+
            "<foreach collection='list' item='custId' open='(' close=')' separator=','> #{custId}</foreach> "+
            " </script>"})
    void deleteSelect(List<String> custId);
}