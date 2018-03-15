package com.simpleShop.serviceImpl;

import com.simpleShop.dao.UserDao;
import com.simpleShop.entity.RoleUser;
import com.simpleShop.entity.User;
import com.simpleShop.service.UserService;
import com.simpleShop.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService
{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @Override
    public void save(User user) throws Exception {
        user.setRoleUser(RoleUser.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        validator.validate(user);
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userDao.findOne(id);
        userDao.delete(user);
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByName(s);
    }
}
