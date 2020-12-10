package com.itdfq.dormitory.model;

import lombok.Data;

/**
 *
 */
@Data
public class Sushe {
    private Integer did;
    private String dname;
    private String address;
    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return dname;
    }

    public void setName(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }



    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDaddress() {
        return address;
    }

    public void setDaddress(String address) {
        this.address = address;
    }


}