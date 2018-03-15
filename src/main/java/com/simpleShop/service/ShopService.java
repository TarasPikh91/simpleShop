package com.simpleShop.service;

import com.simpleShop.entity.Commodity;
import com.simpleShop.entity.Shop;

import java.util.List;

public interface ShopService {

    void save(Shop shop) throws Exception;

    void update(Shop shop);

    Shop findOne(int id);

    List<Shop> findAll();

    void delete(int id);

    Shop shopWithCommodities(int id);

}
