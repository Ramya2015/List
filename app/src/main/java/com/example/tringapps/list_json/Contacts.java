package com.example.tringapps.list_json;

import java.io.Serializable;

/**
 * Created by TRINGAPPS on 02/11/2015.
 */
public class Contacts implements  Serializable{
    private String id,name,email,address,gender,mobile,home,office;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getOffice() {
        return office;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {

        return mobile;
    }

    public String getHome() {
        return home;
    }

    public String getAddress() {
        return address;
    }
}
