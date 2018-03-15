package com.simpleShop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String commodityName;
    private String price;
    private String description;
    private String amount;


    @ManyToMany
    @JoinTable(name = "shop_commodity", joinColumns = @JoinColumn(name = "commodity_id"), inverseJoinColumns = @JoinColumn(name = "shop_id"))
    private List<Shop> shops = new ArrayList<Shop>();

    public Commodity(){

    }

    public Commodity(String commodityName, String price, String description, String amount) {
        this.commodityName = commodityName;
        this.price = price;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
