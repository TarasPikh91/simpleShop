package com.simpleShop.validation.userValidator;

import com.simpleShop.dao.UserDao;
import com.simpleShop.entity.User;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

       if (user.getName().isEmpty()){
           throw new UserException(UserValidatorMessages.USER_NAME_EMPTY);
       }else if(userDao.findByName(user.getName()) != null){
           throw new UserException(UserValidatorMessages.USER_ALREADY_EXIST);
       }else if (user.getPassword().isEmpty()){
           throw new UserException(UserValidatorMessages.USER_PASSWORD_EMPTY);
       }else if (user.getPassword().length()<6){
           throw new UserException(UserValidatorMessages.PASSWORD_SHORT);
       }else if(user.getEmail().isEmpty()){
           throw new UserException(UserValidatorMessages.EMAIL_FIELD_EMPTY);
       }else if (userDao.findByEmail(user.getEmail())!= null){
           throw new UserException(UserValidatorMessages.EMAIL_EXIST);
       }
    }
}
