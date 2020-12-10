package com.itdfq.dormitory.service;

import com.itdfq.dormitory.dao.StudentDAO;
import com.itdfq.dormitory.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date: 2020/12/9 14:48
 * @author: itdfq
 * @Email: 909256107@qq.com
 * @Blog: itdfq.com
 * @description:
 */
@Service
public class StudentService {

    @Resource
    private StudentDAO studentDAO;

    public List<Student> findByPage() {
        List<Student> list = studentDAO.findByPage();
        return list;
    }

    public List<Student> findByTJ(Student student){
        List<Student> list = studentDAO.findByTJ(student);
        return list;
    }
    @Transactional
    public void insert(Student student){
        studentDAO.insert(student);
    }
    @Transactional
    public void update(Student student){
        studentDAO.update(student);
    }
    @Transactional
    public void delete(int did){
        studentDAO.delete(did);
    }
    @Transactional
    public void deleteSelect(List<String> custId) {
        studentDAO.deleteSelect(custId);
    }
}
