package com.simpleShop.validation.commodityValidator;

import com.simpleShop.dao.CommodityDao;
import com.simpleShop.entity.Commodity;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommodityValidator implements Validator{

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void validate(Object o) throws Exception {

        Commodity commodity = (Commodity) o;

        if (commodity.getCommodityName().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_NAME_EMPTY_FIELD);
        }else if(commodityDao.findByCommodityName(commodity.getCommodityName()) != null){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_ALREADY_EXIST);
        }else if(commodity.getDescription().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_DESCRIPTION_EMPTY);
        } else if(commodity.getAmount().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_AMOUNT);
        }else if(commodity.getAmount().matches("[0-9]*") == false){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_AMOUNT_ONLY_DIGITS);
        }else if(commodity.getPrice().length() == 0){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_PRICE_EMPTY);
        }else if(commodity.getPrice().matches("[0-9]*")==false){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_PRICE_ONLY_DIGITS);
        }
    }
}
