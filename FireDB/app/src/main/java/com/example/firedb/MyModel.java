package com.example.firedb;

public class MyModel {
    String url,name,mail,phone,actype,state,district,village,hno,colony,lmarl;


    public MyModel(String url, String name, String mail, String phone, String actype, String state, String district, String village, String hno, String colony, String lmarl) {
        this.url = url;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.actype = actype;
        this.state = state;
        this.district = district;
        this.village = village;
        this.hno = hno;
        this.colony = colony;
        this.lmarl = lmarl;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getActype() {
        return actype;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getVillage() {
        return village;
    }

    public String getHno() {
        return hno;
    }

    public String getColony() {
        return colony;
    }

    public String getLmarl() {
        return lmarl;
    }
}
