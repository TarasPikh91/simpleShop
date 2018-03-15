package com.simpleShop.controller;

import com.simpleShop.entity.User;
import com.simpleShop.service.UserService;
import com.simpleShop.validation.Validator;
import com.simpleShop.validation.logInValidator.LogInValidatorMessages;
import com.simpleShop.validation.userValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", new User());
        return "index";
    }


    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "index";
    }


    @PostMapping("/signUp")
    public String signUp(Model model, @ModelAttribute User user){

        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidatorMessages.USER_NAME_EMPTY) ||
                    e.getMessage().equals(UserValidatorMessages.USER_ALREADY_EXIST)){
                model.addAttribute("userNameException", e.getMessage());
            }else if(e.getMessage().equals(UserValidatorMessages.USER_PASSWORD_EMPTY)||
                    e.getMessage().equals(UserValidatorMessages.PASSWORD_SHORT)){
                model.addAttribute("userPasswordException", e.getMessage());
            }else if(e.getMessage().equals(UserValidatorMessages.EMAIL_FIELD_EMPTY)||
                    e.getMessage().equals(UserValidatorMessages.EMAIL_EXIST)){
                model.addAttribute("userEmailException", e.getMessage());
            }
            return "index";
        }
        return "index";
    }
}
