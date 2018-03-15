package com.simpleShop.validation.userValidator;

public interface UserValidatorMessages {

    String USER_NAME_EMPTY = "user name empty";
    String USER_ALREADY_EXIST = "this user already exist";

    String USER_PASSWORD_EMPTY ="user password empty";
    String PASSWORD_SHORT = "enter more then 6 chars";

    String EMAIL_FIELD_EMPTY ="email field empty";
    String EMAIL_EXIST = "this email already exist";
}
