package com.itdfq.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdfq.dormitory.model.Users;
import com.itdfq.dormitory.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date: 2020/12/8 20:03
 * @author: itdfq
 * @Email: 909256107@qq.com
 * @Blog: itdfq.com
 * @description:
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    private Map<String,Object> map = new HashMap<>();
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody Users users ,HttpServletRequest request){
        map.clear();
        try {
            Users login = usersService.findByUsername(users.getUsername());
            if (login == null) {
                map.put("msg", "用户名不存在！");
                return map;
            }
            if (!login.getPassword().equals(users.getPassword())) {
                map.put("msg", "用户名或密码错误！");
                return map;
            }
            map.put("msg", "1");
            request.getSession().setAttribute("user", login);
            map.put("role",login.getRole());
            map.put("name",login.getRealname());

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;

    }
    @RequestMapping("/findByUser")
    public Map<String,Object> findByUser(HttpSession session){
        try {
            Users user = (Users) session.getAttribute("user");
            if (user==null){
                map.put("msg","用户登录异常，请重新登录");
                return map;
            }else {
                map.put("role",user.getRole());
                map.put("msg",1);
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }


    @RequestMapping("/findByPage")
    public Map<String,Object> findByPage(@RequestParam(required = false, defaultValue = "1") int page,  @RequestParam(required = false, defaultValue = "10") int limit){
        PageHelper.startPage(page, limit);
        map.clear();
        try {
            List<Users> users = usersService.findByPage();
            PageInfo<Users> pageInfo = new PageInfo<>(users);
            map.put("count",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            map.put("code",0);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    //条件查询
    @RequestMapping("/findByTJ")
    public Map<String,Object> findByTJ(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int limit, @RequestBody Users users){
        PageHelper.startPage(page, limit);
        map.clear();

        try {
            List<Users> byTJ = usersService.findByTJ(users);
            PageInfo<Users> pageInfo = new PageInfo<>(byTJ);
            map.put("count",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            map.put("code",0);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }


    //删除操作
    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestBody Users users){
        System.out.println(users);
        map.clear();
        try {
            usersService.delete(users.getUid());
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
//    更新操作
    @RequestMapping("/update")
    public Map<String,Object> update(@RequestBody  Users users){
        map.clear();
        try {
            usersService.update(users);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    //插入操作
    @RequestMapping("/insert")
    public Map<String,Object> insert(@RequestBody  Users users){
        map.clear();
        try {
            usersService.insert(users);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

//    批量删除
    @RequestMapping("/deleteSelect")
    public Map<String,Object> deleteSelect(String id){
        map.clear();
        try {
            List<String> list = new ArrayList<>();
            String[] strs = id.split(",");
            for (String str : strs) {
                list.add(str);
            }
            usersService.deleteSelect(list);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }


}
