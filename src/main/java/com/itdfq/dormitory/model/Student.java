package com.itdfq.dormitory.model;

import lombok.Data;

/**
 *
 */
@Data
public class Student {
    /**
     *
     */
    private Integer sid;
    /**
     *
     */
    private String sno;
    /**
     *
     */
    private String sname;
    /**
     *
     */
    private String sphone;
    /**
     *
     */
    private String sclass;
    /**
     * 对应的宿舍楼表
     */
   private String daddress;
    /**
     * 宿舍门牌号
     */
    private String ssushe;
    /**
     * 判断是否为空
     */


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public String getSsushe() {
        return ssushe;
    }

    public void setSsushe(String ssushe) {
        this.ssushe = ssushe;
    }


}