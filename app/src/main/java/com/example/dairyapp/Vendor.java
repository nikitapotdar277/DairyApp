package com.example.dairyapp;

public class Vendor {
    private String VendorFirstName,VendorLastName,VendorMobile,VendorEmailID,VendorDairyAddress,VendorDairyName,VendorUsername_reg,VendorPassword_reg;

    public Vendor() {
    }

    public void setFirstName(String vendorfirstName) {

        VendorFirstName = vendorfirstName;
    }

    public void setLastName(String vendorlastName) {

        VendorLastName = vendorlastName;
    }

    public void setMobile(String vendormobile) {

        VendorMobile = vendormobile;
    }

    public void setEmailID(String vendoremailID) {

        VendorEmailID = vendoremailID;
    }

    public void setDairyName(String vendordairyname){
      VendorDairyName = vendordairyname;
    }

    public void setDairyAddress(String vendordairyaddress) {
        VendorDairyAddress = vendordairyaddress;
    }

    public void setUsername_reg(String vendorusername_reg) {

        VendorUsername_reg = vendorusername_reg;
    }

    public void setPassword_reg(String vendorpassword_reg) {

        VendorPassword_reg = vendorpassword_reg;
    }

    public Vendor(String VendorFirstName, String VendorLastName, String VendorMobile, String VendorEmailID,String VendorDairyName, String VendorDairyAddress, String VendorUsername_reg, String VendorPassword_reg) {
        this.VendorFirstName=VendorFirstName;
        this.VendorLastName=VendorLastName;
        this.VendorMobile=VendorMobile;
        this.VendorEmailID=VendorEmailID;
        this.VendorDairyName = VendorDairyName;
        this.VendorDairyAddress=VendorDairyAddress;
        this.VendorUsername_reg=VendorUsername_reg;
        this.VendorPassword_reg=VendorPassword_reg;
    }

    public String getFirstName() {
        return VendorFirstName;
    }

    public String getLastName() {
        return VendorLastName;
    }

    public String getMobile() {
        return VendorMobile;
    }

    public String getEmailID() {
        return VendorEmailID;
    }

    public String getDairyName() {
      return VendorDairyName;
    }

    public String getDairyAddress() {
        return VendorDairyAddress;
    }

    public String getUsername_reg() {
        return VendorUsername_reg ;
    }

    public String getPassword_reg() {
        return VendorPassword_reg;
    }
}
