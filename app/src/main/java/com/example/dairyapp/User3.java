package com.example.dairyapp;

public class User3 {
    private String uname,item1,date,total1,qt;
    private String FirstName,LastName,Mobile,EmailID,Address,Username_reg,Password_reg;
    private String MyOrder;

    public User3(){}

    public User3(String uname, String item1, String date, String total1, String qt, String firstName, String lastName, String mobile, String emailID, String address, String username_reg, String password_reg,String MyOrder) {
        this.uname = uname;
        this.item1 = item1;
        this.date = date;
        this.total1 = total1;
        this.qt = qt;
        FirstName = firstName;
        LastName = lastName;
        Mobile = mobile;
        EmailID = emailID;
        Address = address;
        Username_reg = username_reg;
        Password_reg = password_reg;
        this.MyOrder=MyOrder;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal1() {
        return total1;
    }

    public void setTotal1(String total1) {
        this.total1 = total1;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUsername_reg() {
        return Username_reg;
    }

    public void setUsername_reg(String username_reg) {
        Username_reg = username_reg;
    }

    public String getPassword_reg() {
        return Password_reg;
    }

    public void setPassword_reg(String password_reg) {
        Password_reg = password_reg;
    }

    public String getMyOrder() {
        return MyOrder;
    }

    public void setMyOrder(String myOrder) {
        MyOrder = myOrder;
    }

}
