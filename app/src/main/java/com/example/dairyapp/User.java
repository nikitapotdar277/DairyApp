package com.example.dairyapp;

public class User {
    private String FirstName,LastName,Mobile,EmailID,Address,Username_reg,Password_reg;

    public User() {
    }

    public void setFirstName(String firstName) {

        FirstName = firstName;
    }

    public void setLastName(String lastName) {

        LastName = lastName;
    }

    public void setMobile(String mobile) {

        Mobile = mobile;
    }

    public void setEmailID(String emailID) {

        EmailID = emailID;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setUsername_reg(String username_reg) {

        Username_reg = username_reg;
    }

    public void setPassword_reg(String password_reg) {

        Password_reg = password_reg;
    }

    public User(String FirstName, String LastName, String Mobile, String EmailID, String Address, String Username_reg, String Password_reg) {
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.Mobile=Mobile;
        this.EmailID=EmailID;
        this.Address=Address;
        this.Username_reg=Username_reg;
        this.Password_reg=Password_reg;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getAddress() {
        return Address;
    }

    public String getUsername_reg() {
        return Username_reg;
    }

    public String getPassword_reg() {
        return Password_reg;
    }
}
