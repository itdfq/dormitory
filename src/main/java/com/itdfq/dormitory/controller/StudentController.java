package com.itdfq.dormitory.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itdfq.dormitory.model.Student;

import com.itdfq.dormitory.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Map<String,Object> map = new HashMap<>();


    @RequestMapping("/findByPage")
    public Map<String,Object> findByPage(@RequestParam(required = false, defaultValue = "1") int page,  @RequestParam(required = false, defaultValue = "10") int limit){
        PageHelper.startPage(page, limit);
        map.clear();

        try {
            List<Student> students = studentService.findByPage();

            PageInfo<Student> pageInfo = new PageInfo<>(students);
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

    @RequestMapping("/findByTJ")
    public Map<String,Object> findByTJ(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int limit, @RequestBody Student student){
        PageHelper.startPage(page, limit);
        map.clear();
        try {
            List<Student> byTJ = studentService.findByTJ(student);
            PageInfo<Student> pageInfo = new PageInfo<>(byTJ);
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

    @RequestMapping("/deleteSelect")
    public Map<String,Object> deleteSelect(String id){
        map.clear();
        try {
            List<String> list = new ArrayList<>();
            String[] strs = id.split(",");
            for (String str : strs) {
                list.add(str);
            }
            studentService.deleteSelect(list);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }


    @RequestMapping("/delete")
    public Map<String,Object> delete(@RequestBody Student student){
        map.clear();
        try {
            studentService.delete(student.getSid());
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @RequestMapping("/update")
    public Map<String,Object> update(@RequestBody  Student student){
        map.clear();
        try {
            studentService.update(student);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/insert")
    public Map<String,Object> insert(@RequestBody  Student  student){
        map.clear();
        try {
            studentService.insert(student);
            map.put("msg",1);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }


}
