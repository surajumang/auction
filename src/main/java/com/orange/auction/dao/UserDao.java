package com.orange.auction.dao;

import com.orange.auction.model.Member;

import java.util.List;

public interface UserDao {
    Member getUserByEmail(String email);
    List<Member> getAllUsers();
    void addUser(Member member);
}
