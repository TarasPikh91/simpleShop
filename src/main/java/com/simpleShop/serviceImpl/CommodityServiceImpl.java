package com.simpleShop.serviceImpl;

import com.simpleShop.dao.CommodityDao;
import com.simpleShop.dao.ShopDao;
import com.simpleShop.entity.Commodity;
import com.simpleShop.entity.Shop;
import com.simpleShop.service.CommodityService;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    private ShopDao shopDao;

    @Autowired
    @Qualifier("commodityValidator")
    private Validator validator;

    @Override
    public void save(Commodity commodity, List<Integer> shop_ids) throws Exception {

        validator.validate(commodity);
        commodityDao.saveAndFlush(commodity);
        for (Integer id : shop_ids) {
            Shop shop = shopDao.shopWithCommodities(id);
            shop.getCommodities().add(commodity);
            shopDao.save(shop);
        }

        commodityDao.save(commodity);
    }

    @Override
    public void update(Commodity commodity, List<Integer> shop_ids) {


        List<Shop> shops = new ArrayList<>();
        for (Integer id: shop_ids){
            Shop shop = shopDao.findOne(id);
            shops.add(shop);
        }
        commodity.setShops(shops);

        commodityDao.save(commodity);
    }

    @Override
    public Commodity findOne(int id) {
        return commodityDao.findOne(id);
    }

    @Override
    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    @Override
    public void delete(int id) {
        Commodity commodity = commodityDao.findOne(id);
        commodityDao.delete(commodity);
    }

    @Override
    public Commodity commodityWithShops(int id) {
        return commodityDao.commodityWithShops(id);
    }

 }
