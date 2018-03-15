package com.simpleShop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String shopName;
    private String address;


    @ManyToMany
    @JoinTable(name = "shop_commodity", joinColumns = @JoinColumn(name="shop_id"), inverseJoinColumns = @JoinColumn(name="commodity_id"))
    private List<Commodity> commodities = new ArrayList<Commodity>();

    public Shop() {
    }

    public Shop(String shopName, String address) {
        this.shopName = shopName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
