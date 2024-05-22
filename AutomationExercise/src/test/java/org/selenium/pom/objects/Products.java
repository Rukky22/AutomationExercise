package org.selenium.pom.objects;

import org.selenium.pom.utils.JacksonUtils;

import java.io.IOException;

public class Products {
    private String name;
    private int id;

    private String price;

    public Products(){}

    public Products(int id) {
        Products [] products = new Products[0];
        products = JacksonUtils.deserializeJson("product.json", Products[].class);
        for (Products product :products) {
            if (product.getId() == id){
                this.id = product.getId();
                this.name = product.getName();
                this.price = product.getPrice();
            }
        }

    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
