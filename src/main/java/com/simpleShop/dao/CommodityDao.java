package com.simpleShop.dao;

import com.simpleShop.entity.Commodity;
import com.simpleShop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {


    @Query("select distinct c from Commodity c left join fetch c.shops where c.id=:id")
    Commodity commodityWithShops(@Param("id") int id);

    Commodity findByCommodityName(String commodityName);

}
