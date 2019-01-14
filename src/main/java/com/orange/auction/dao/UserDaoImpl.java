package com.orange.auction.dao;

import com.orange.auction.model.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member getUserByEmail(String email){
        String hql = "from user where email= :email";
        return entityManager.createQuery(hql, Member.class)
                .setParameter("email", email)
                .getResultStream()
                .findAny()
                .orElse(Member.getDummyMember());
    }

    @Override
    public void addUser(Member member) {
        entityManager.persist(member);
    }

    @Override
    public List<Member> getAllUsers() {
        return entityManager.createQuery("from user", Member.class)
                .getResultStream().collect(Collectors.toList());
    }
}
