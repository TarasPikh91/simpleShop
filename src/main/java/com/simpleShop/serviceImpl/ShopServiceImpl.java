package com.simpleShop.serviceImpl;

import com.simpleShop.dao.CommodityDao;
import com.simpleShop.dao.ShopDao;
import com.simpleShop.entity.Shop;
import com.simpleShop.service.ShopService;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    @Qualifier("shopValidator")
    private Validator validator;

    @Override
    public void save(Shop shop) throws Exception {

        validator.validate(shop);
        shopDao.save(shop);
    }

    @Override
    public void update(Shop shop) {

        shopDao.save(shop);
    }

    @Override
    public Shop findOne(int id) {

        Shop shop = shopDao.findOne(id);

        return shop;
    }

    @Override
    public List<Shop> findAll() {
        return  shopDao.findAll();
    }

    @Override
    public void delete(int id) {
        Shop shop = shopDao.findOne(id);
        shopDao.delete(shop);
    }

    @Override
    public Shop shopWithCommodities(int id) {
        return shopDao.shopWithCommodities(id);
    }
}
