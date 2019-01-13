package com.orange.auction.service;

import com.orange.auction.model.User;

import java.util.List;

public interface UserService {
    User getUser(String email);
    List<User> getUsers();
}
