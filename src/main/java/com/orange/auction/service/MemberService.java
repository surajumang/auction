package com.orange.auction.service;

import com.orange.auction.model.Member;

import java.util.List;

public interface MemberService {
    Member getById(Long id);
    Member getUser(String email);
    List<Member> getUsers();
    void addUser(Member member);
}
