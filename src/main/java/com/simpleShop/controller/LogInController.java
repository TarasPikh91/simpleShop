package com.simpleShop.controller;

import com.simpleShop.entity.User;
import com.simpleShop.service.UserService;
import com.simpleShop.validation.Validator;
import com.simpleShop.validation.logInValidator.LogInValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("logInValidator")
    private Validator validator;

    @GetMapping("/login")
    public String logIn(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @PostMapping("/login")
    public String logIn(){

        return "index";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username,
                               @RequestParam String password){

        try {
            validator.validate(new User(username, password));
        } catch (Exception e) {
            if (e.getMessage().equals(LogInValidatorMessages.WRONG_USERNAME) ||
                    e.getMessage().equals(LogInValidatorMessages.WRONG_PASSWORD)){
                model.addAttribute("logInException", e.getMessage());
            }

            model.addAttribute("user", new User());
            return "index";
        }
        System.out.println("hello");
        return "index";
    }
}
