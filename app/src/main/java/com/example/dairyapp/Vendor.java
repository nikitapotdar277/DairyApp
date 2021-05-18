package com.example.dairyapp;

public class Vendor {
    public Vendor(String vendorFirstName) {
        VendorFirstName = vendorFirstName;
    }

    public String getVendorFirstName() {
        return VendorFirstName;
    }

    public void setVendorFirstName(String vendorFirstName) {
        VendorFirstName = vendorFirstName;
    }

    private String VendorFirstName;

    public String getVendorLastName() {
        return VendorLastName;
    }

    public void setVendorLastName(String vendorLastName) {
        VendorLastName = vendorLastName;
    }

    private String VendorLastName;

    public String getVendorMobile() {
        return VendorMobile;
    }

    public void setVendorMobile(String vendorMobile) {
        VendorMobile = vendorMobile;
    }

    private String VendorMobile;

    public String getVendorEmailID() {
        return VendorEmailID;
    }

    public void setVendorEmailID(String vendorEmailID) {
        VendorEmailID = vendorEmailID;
    }

    private String VendorEmailID;

    public String getVendorDairyAddress() {
        return VendorDairyAddress;
    }

    public void setVendorDairyAddress(String vendorDairyAddress) {
        VendorDairyAddress = vendorDairyAddress;
    }

    private String VendorDairyAddress;

    public String getVendorDairyName() {
        return VendorDairyName;
    }

    public void setVendorDairyName(String vendorDairyName) {
        VendorDairyName = vendorDairyName;
    }

    private String VendorDairyName;

    public String getVendorUsername_reg() {
        return VendorUsername_reg;
    }

    public void setVendorUsername_reg(String vendorUsername_reg) {
        VendorUsername_reg = vendorUsername_reg;
    }

    private String VendorUsername_reg;

    public String getVendorPassword_reg() {
        return VendorPassword_reg;
    }

    public void setVendorPassword_reg(String vendorPassword_reg) {
        VendorPassword_reg = vendorPassword_reg;
    }

    private String VendorPassword_reg;

    public Vendor() {
    }

//    public void setFirstName(String vendorfirstName) {
//
//        VendorFirstName = vendorfirstName;
//    }
//
//    public void setLastName(String vendorlastName) {
//
//        VendorLastName = vendorlastName;
//    }
//
//    public void setMobile(String vendormobile) {
//
//        VendorMobile = vendormobile;
//    }
//
//    public void setEmailID(String vendoremailID) {
//
//        VendorEmailID = vendoremailID;
//    }
//
//    public void setDairyName(String vendordairyname){
//      VendorDairyName = vendordairyname;
//    }
//
//    public void setDairyAddress(String vendordairyaddress) {
//        VendorDairyAddress = vendordairyaddress;
//    }
//
//    public void setUsername_reg(String vendorusername_reg) {
//
//        VendorUsername_reg = vendorusername_reg;
//    }
//
//    public void setPassword_reg(String vendorpassword_reg) {
//
//        VendorPassword_reg = vendorpassword_reg;
//    }

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

//    public String getFirstName() {
//        return VendorFirstName;
//    }
//
//    public String getLastName() {
//        return VendorLastName;
//    }
//
//    public String getMobile() {
//        return VendorMobile;
//    }
//
//    public String getEmailID() {
//        return VendorEmailID;
//    }
//
//    public String getDairyName() {
//      return VendorDairyName;
//    }
//
//    public String getDairyAddress() {
//        return VendorDairyAddress;
//    }
//
//    public String getVUsername_reg() {
//        return VendorUsername_reg ;
//    }
//
//    public String getVPassword_reg() {
//        return VendorPassword_reg;
//    }
}
