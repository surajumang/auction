package com.orange.auction.service;

import com.orange.auction.dao.UserDao;
import com.orange.auction.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Member getUser(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void addUser(Member member) {
        userDao.addUser(member);
    }

    @Override
    public List<Member> getUsers() {
        return userDao.getAllUsers();
    }
}
