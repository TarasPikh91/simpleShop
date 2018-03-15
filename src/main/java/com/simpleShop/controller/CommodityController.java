package com.simpleShop.controller;

import com.simpleShop.entity.Commodity;
import com.simpleShop.entity.Shop;
import com.simpleShop.service.CommodityService;
import com.simpleShop.service.ShopService;
import com.simpleShop.validation.commodityValidator.CommodityValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private ShopService shopService;

    @GetMapping("/commodity")
    public String commodity(Model model){
        model.addAttribute("commodities", commodityService.findAll());
        model.addAttribute("shops", shopService.findAll());
        return "commodity";
    }

    @PostMapping("/saveCommodity")
    public String saveCommodity(@RequestParam String commodityName, @RequestParam String commodityPrice,
                                @RequestParam String commodityDescription, @RequestParam String amount, @RequestParam List<Integer> shop_ids, Model model){

        List<Shop> shops = new ArrayList<>();
        for(Integer id: shop_ids){
            shops.add(shopService.findOne(id));
        }

        Commodity commodity = new Commodity();
        commodity.setCommodityName(commodityName);
        commodity.setAmount(amount);
        commodity.setDescription(commodityDescription);
        commodity.setPrice(commodityPrice);
        commodity.setShops(shops);
        try {
            commodityService.save(commodity, shop_ids);
        } catch (Exception e) {
            if (e.getMessage().equals(CommodityValidatorMessages.COMMODITY_NAME_EMPTY_FIELD)||
                    e.getMessage().equals(CommodityValidatorMessages.COMMODITY_ALREADY_EXIST)){
                model.addAttribute("commodityNameException", e.getMessage());
            }else if(e.getMessage().equals(CommodityValidatorMessages.COMMODITY_AMOUNT) ||
                    e.getMessage().equals(CommodityValidatorMessages.COMMODITY_AMOUNT_ONLY_DIGITS)){
                model.addAttribute("commodityAmountException", e.getMessage());
            }else if(e.getMessage().equals(CommodityValidatorMessages.COMMODITY_DESCRIPTION_EMPTY)){
                model.addAttribute("commodityDescriptionException", e.getMessage());
            }else if (e.getMessage().equals(CommodityValidatorMessages.COMMODITY_PRICE_EMPTY) ||
                    e.getMessage().equals(CommodityValidatorMessages.COMMODITY_PRICE_ONLY_DIGITS)){
                model.addAttribute("commodityPriceException", e.getMessage());
            }

            model.addAttribute("shops", shopService.findAll());
            model.addAttribute("commodities", commodityService.findAll());
            return "commodity";
        }
        return "redirect:/commodity";
    }

    @GetMapping("/updateCommodity/{id}")
    public String updateCommodity(Model model, @PathVariable int id){

        Commodity commodity = commodityService.findOne(id);
        model.addAttribute("commodityToUpdate", commodity);
        model.addAttribute("commodityShops", commodityService.commodityWithShops(id));
        model.addAttribute("shops", shopService.findAll());
        return "updateCommodity";
    }

    @PostMapping("/updateCommodity/{id}")
    public String updateCommodity(@PathVariable int id, @RequestParam String commodityName, @RequestParam String commodityPrice,
                                  @RequestParam String commodityDescription, @RequestParam String amount, @RequestParam List<Integer> shop_ids, Model model){


        Commodity commodity = commodityService.findOne(id);
        commodity.setCommodityName(commodityName);
        commodity.setPrice(commodityPrice);
        commodity.setDescription(commodityDescription);
        commodity.setAmount(amount);

        commodityService.update(commodity, shop_ids);
        model.addAttribute("commodities", commodityService.findAll());
        return "commodity";
    }

    @GetMapping("/deleteCommodity/{id}")
    public String deleteCommodity(@PathVariable int id){
        commodityService.delete(id);
        return "redirect:/commodity";
    }
}
