package org.cafesss.sssmenu;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    String id;
    String product;
    int price;
    int prodnum;
    int totalprice;
    String size;
    int pic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Cart(String id, String product, int price, int prodnum, int totalprice, String size, int pic)
    {
        this.id=id;
        this.product=product;
        this.price=price;
        this.prodnum=prodnum;
        this.totalprice=totalprice;
        this.size=size;
        this.pic=pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}