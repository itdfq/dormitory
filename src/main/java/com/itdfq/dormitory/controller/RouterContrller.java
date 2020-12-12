package com.itdfq.dormitory.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @date: 2020/11/25 15:50
 * @author: itdfq
 * @Email: 909256107@qq.com
 * @Blog: itdfq.com
 * @description:
 */
@Controller
public class RouterContrller {
    // 登陆页（首页）
    @GetMapping("/home")
    public String indexHome() {
        return "index";
    }

    // 登陆页（首页）
    @GetMapping("/")
    public String indexPage() {
        return "login";
    }


    // 退出系统
    @RequestMapping("/logout")
    public String administratorLogout(HttpSession session) {
        session.setAttribute("user", null);
//        session.setAttribute("adminName",null);
        return "login";
    }



//    //管理员主页
//    @GetMapping("/admin")
//    public String admin() {
//        return "admin/index";
//    }
//
//    //客户主页
//    @GetMapping("/customer")
//    public String customer() {
//        return "index";
//    }
//
//    //管理员菜单：客户管理
//    @GetMapping("/user")
//    public String user() {
//        return "admin/user";
//    }
//    //管理员菜单：设备管理
//    @GetMapping("/equipment")
//    public String equipment() {
//        return "admin/equipment";
//    }
//    //管理员菜单：权限管理
//    @GetMapping("/authority")
//    public String authority() {
//        return "admin/authority";
//    }
//    //管理员菜单：
//
//    // 退出系统
//    @RequestMapping("/logout")
//    public String administratorLogout(HttpSession session) {
//        session.setAttribute("user", null);
//        session.setAttribute("adminName",null);
//        return "login";
//    }
}
