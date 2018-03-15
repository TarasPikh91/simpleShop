package com.simpleShop.dao;

import com.simpleShop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopDao extends JpaRepository<Shop, Integer> {

    @Query("select s from Shop s left join fetch s.commodities where s.id=:id")
    Shop shopWithCommodities(@Param("id")int id);

    Shop findByShopName(String shopName);
    Shop findByAddress(String ShopAddress);
}
