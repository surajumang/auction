package com.orange.auction.service;

import com.orange.auction.dao.UserDao;
import com.orange.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }
}
