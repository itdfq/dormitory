package com.itdfq.dormitory.dao;


import com.itdfq.dormitory.model.Sushe;
import com.itdfq.dormitory.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *
 */
public interface SusheDAO {



    @Select("select * from sushe  ")
    List<Sushe> findByPage();

    @Select("select * from sushe where dname like concat('%',#{dname},'%')  ")
    List<Sushe> findByTJ(Sushe sushe);

    @Delete("delete from sushe where did = #{did}")
    void delete(int did);

    @Insert("insert into sushe(dname,address) values(#{dname},#{address})")
    void insert(Sushe sushe);

    @Update("update sushe set dname=#{dname},address=#{address}  where did=#{did}")
    void update(Sushe sushe);

    @Select(" SELECT distinct dname  FROM sushe")
    List<Sushe> myselect();

    @Delete({"<script>" +
            " delete from  sushe  where did  in "+
            "<foreach collection='list' item='custId' open='(' close=')' separator=','> #{custId}</foreach> "+
            " </script>"})
    void deleteSelect(List<String> custId);



}