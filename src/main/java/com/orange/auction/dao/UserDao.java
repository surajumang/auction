package com.orange.auction.dao;

import com.orange.auction.model.User;

import java.util.List;

public interface UserDao {
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
