package com.simpleShop.service;

import com.simpleShop.entity.Commodity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommodityService {


    void save(Commodity commodity, List<Integer> shop_Ids) throws Exception;

    void update(Commodity commodity, List<Integer> shop_Ids);

    Commodity findOne(int id);

    List<Commodity> findAll();

    void delete(int id);

    Commodity commodityWithShops(int id);
}
