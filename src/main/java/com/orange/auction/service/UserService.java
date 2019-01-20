package com.orange.auction.service;

import com.orange.auction.model.Member;

import java.util.List;

public interface UserService {
    Member getUser(String email);
    List<Member> getUsers();
    void addUser(Member member);
}
