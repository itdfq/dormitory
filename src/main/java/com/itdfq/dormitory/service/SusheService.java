package com.itdfq.dormitory.service;

import com.itdfq.dormitory.dao.SusheDAO;
import com.itdfq.dormitory.model.Sushe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @date: 2020/12/9 14:50
 * @author: itdfq
 * @Email: 909256107@qq.com
 * @Blog: itdfq.com
 * @description:
 */
@Service
public class SusheService {

    @Resource
    private SusheDAO susheDAO;

   public List<Sushe> findByPage(){
        List<Sushe> byPage = susheDAO.findByPage();
        return byPage;
    }
  public  List<Sushe> findByTJ(Sushe sushe){
        List<Sushe> byTJ = susheDAO.findByTJ(sushe);
        return byTJ;
    }
    @Transactional
   public void insert(Sushe sushe){
        susheDAO.insert(sushe);
    }
    @Transactional
  public  void update(Sushe sushe){
        susheDAO.update(sushe);
    }

    @Transactional
    public void delete(int sid){
        susheDAO.delete(sid);
    }
    @Transactional
    public List<Sushe> myselect(){
        List<Sushe> myselect = susheDAO.myselect();
        return myselect;
    }
    @Transactional
    public void deleteSelect(List<String> custId) {
        susheDAO.deleteSelect(custId);
    }
}
