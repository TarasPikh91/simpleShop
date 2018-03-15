package com.simpleShop.validation.logInValidator;

import com.simpleShop.dao.UserDao;
import com.simpleShop.entity.User;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
public class LogInValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {
        User user = (User)o;

        if (userDao.findByName(user.getName()) == null){
            throw new LogInException(LogInValidatorMessages.WRONG_USERNAME);
        }else if(encoder.matches(user.getPassword(), userDao.findByName(user.getName()).getPassword())){
            throw new LogInException(LogInValidatorMessages.WRONG_PASSWORD);
        }
    }
}
