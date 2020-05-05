package org.cafesss.sssmenu;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;


public class Order {

    String id, name, phone, product, size, orderedtime, deleted;
    int price, totalprice, prodnum;

    Order(String id, String name, String phone, String product,String size,int prodnum,String deleted)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.product = product;
        this.size = size;
        this.price = 0;
        this.prodnum = prodnum;
        this.orderedtime="null";
        this.totalprice=0;
        this.deleted=deleted;
    }

    void putProd(String product, int prodnum, String size, String deleted)
    {
        this.product=product;
        this.size=size;
        this.deleted=deleted;
        this.prodnum=prodnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProdnum() {
        return prodnum;
    }

    public void setProdnum(int prodnum) {
        this.prodnum = prodnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}