package com.example.dairyapp;

public class Cart {

    private String item1;
    private String total1;
    private String date;
    private String uname;
    private String qt;
    private String status;

    public Cart () {}

    public Cart(String orderDate, String item1Name, String quantity, String item1status, String item1total1, String username) {
        item1=item1Name;
        total1=item1total1;
        date=orderDate;
        uname=username;
        qt=quantity;
        status=item1status;
    }

    public String getStatus () {
        return status;
    }
    public String getitem1(){
        return item1;
    }

    public String gettotal1(){
        return total1;
    }

    public String getDate(){
        return date;
    }

    public String getUname(){ return uname; }

    public String getqt(){ return qt; }

    public void setitem1(String item) {this.item1 = item;}
    public void settotal1(String total1) {this.total1 = total1;}
    public void setDate(String date) {this.date = date;}
    public void setUname(String username) {this.uname = username;}
    public void setqt(String qt) {this.qt = qt;}
    public void setStatus(String status) {this.status = status;}


}
