package com.example.dairyapp;

public class User2 {
    private String uname,item1,date,total1,qt,status;

    public User2(){}//Empty Contructor
    public User2(String uname,String item1,String date,String total1,String qt,String status)
    {
        this.status=status;
        this.uname=uname;
        this.item1=item1;
        this.date=date;
        this.total1=total1;
        this.qt=qt;
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

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status=status; }
}
