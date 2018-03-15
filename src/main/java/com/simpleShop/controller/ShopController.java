package com.simpleShop.controller;

import com.simpleShop.entity.Commodity;
import com.simpleShop.entity.Shop;
import com.simpleShop.service.CommodityService;
import com.simpleShop.service.ShopService;
import com.simpleShop.validation.shopValidator.ShopValidatorMessages;
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
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("shops", shopService.findAll());
        model.addAttribute("commodities", commodityService.findAll());
        return "/shop";
    }

    @PostMapping("/saveShop")
    public String saveShop(@RequestParam String shopName, @RequestParam String shopAddress, Model model){

        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setAddress(shopAddress);

        try {
            shopService.save(shop);
        } catch (Exception e) {
            if (e.getMessage().equals(ShopValidatorMessages.EMPTY_SHOPNAME_FIELD)||
                    e.getMessage().equals(ShopValidatorMessages.SHOP_NAME_ALREADY_EXIST)){
                    model.addAttribute("shopNameException", e.getMessage());
            }else if(e.getMessage().equals(ShopValidatorMessages.SHOPADDRESS_EMPTY_FIELD) ||
                    e.getMessage().equals(ShopValidatorMessages.SHOPADDRESS_ALREADY_EXIST)){
                model.addAttribute("shopAddressException", e.getMessage());
            }
            model.addAttribute("shops", shopService.findAll());
            return "shop";
        }
        return "redirect:/shop";
    }

    @GetMapping("/updateShop/{id}")
    public String updateShop(@PathVariable int id, Model model){

        Shop shop = shopService.findOne(id);
        model.addAttribute("shopToUpdate", shop);
        model.addAttribute("commodities", commodityService.findAll());
        model.addAttribute("shopWithCommodity", shopService.shopWithCommodities(id));

        return "updateShop";
    }

    @PostMapping("/updateShop/{id}")
    public String updateShop(@PathVariable int id, @RequestParam String shopName, @RequestParam String shopAddress, Model model){

        Shop shop = shopService.findOne(id);
        shop.setAddress(shopAddress);
        shop.setShopName(shopName);
        shopService.update(shop);
        model.addAttribute("shops", shopService.findAll());
        return "shop";
    }

    @GetMapping("/deleteShop/{id}")
    public String deleteShop(@PathVariable int id){
        shopService.delete(id);
        return "redirect:/shop";
    }
}
