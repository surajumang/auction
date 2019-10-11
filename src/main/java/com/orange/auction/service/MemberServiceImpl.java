package com.orange.auction.service;

import com.orange.auction.dao.MemberDao;
import com.orange.auction.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member getById(Long id) {
        return memberDao.getById(id);
    }

    @Override
    public Member getUser(String email) {
        return memberDao.getUserByEmail(email);
    }

    @Override
    public void addUser(Member member) {
        memberDao.addUser(member);
    }

    @Override
    public List<Member> getUsers() {
        return memberDao.getAllUsers();
    }
}
