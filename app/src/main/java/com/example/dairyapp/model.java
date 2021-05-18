package com.example.dairyapp;

public class model {

    String name,product,total;

    model(){

    }

    public model(String name) {
        this.name = name;
    }

    public model(String product, String total) {
        this.product = product;
        this.total = total;
    }

    public model(String name, String product, String total) {
        this.name = name;
        this.product = product;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
