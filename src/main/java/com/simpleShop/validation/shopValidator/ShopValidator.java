package com.simpleShop.validation.shopValidator;

import com.simpleShop.dao.ShopDao;
import com.simpleShop.entity.Shop;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopValidator implements Validator {

    @Autowired
    private ShopDao shopDao;

    @Override
    public void validate(Object o) throws Exception {

        Shop shop = (Shop) o;

        if (shop.getShopName().isEmpty()){
            throw new ShopException(ShopValidatorMessages.EMPTY_SHOPNAME_FIELD);
        }else if(shopDao.findByShopName(shop.getShopName()) != null){
            throw new ShopException(ShopValidatorMessages.SHOP_NAME_ALREADY_EXIST);
        }else if(shop.getAddress().isEmpty()){
            throw new ShopException(ShopValidatorMessages.SHOPADDRESS_EMPTY_FIELD);
        }else if(shopDao.findByAddress(shop.getAddress())!= null){
            throw new ShopException(ShopValidatorMessages.SHOPADDRESS_ALREADY_EXIST);
        }

    }
}
