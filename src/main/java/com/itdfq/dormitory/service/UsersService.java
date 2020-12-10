package com.itdfq.dormitory.service;


import com.itdfq.dormitory.dao.UsersDAO;
import com.itdfq.dormitory.model.Users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date: 2020/12/8 20:00
 * @author: itdfq
 * @Email: 909256107@qq.com
 * @Blog: itdfq.com
 * @description:
 */
@Service
public class UsersService {

    /*
    @Autowired
    基于spring的注解org.springframework.beans.factory.annotation.Autowired,它默认是按类型进行的装配的。
    @Resource
    是基于j2ee的注解(可以减少了与spring的耦合)（JDK1.6以上支持）默认是按名字进行注解。
     */

    @Resource
    private UsersDAO usersDAO;
    @Transactional
    public List<Users> findByPage(){

        List<Users> byPage = usersDAO.findByPage();
        return byPage;
    }

    public Users findByUsername(String username){
        Users users = usersDAO.selectByUsername(username);
        return users;
    }
    @Transactional
    public List<Users> findByTJ(Users users){
        List<Users> byTJ = usersDAO.findByTJ(users);
        return byTJ;
    }
    @Transactional
    public void delete(int uid){
        usersDAO.delete(uid);
    }
    @Transactional
    public void update(Users users){
        usersDAO.update(users);
    }
    @Transactional
    public void insert(Users users){
        usersDAO.insert(users);
    }

    @Transactional
    public void deleteSelect(List<String> custId) {
        usersDAO.deleteSelect(custId);
    }



}
