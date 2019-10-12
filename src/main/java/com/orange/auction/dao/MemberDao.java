package com.orange.auction.dao;

import com.orange.auction.model.Member;

import java.util.List;

public interface MemberDao {
    Member getById(Long id);
    Member getUserByEmail(String email);
    List<Member> getAllUsers();
    void addUser(Member member);
    void update(Long id, Member member);
}
