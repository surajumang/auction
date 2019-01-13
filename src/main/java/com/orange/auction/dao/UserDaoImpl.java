package com.orange.auction.dao;

import com.orange.auction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUserByEmail(String email){
        String hql = "from user where email= :email";
        return entityManager.createQuery(hql, User.class)
                .setParameter("email", email)
                .getResultStream()
                .findAny()
                .orElse(User.getDummyUser());
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from user", User.class)
                .getResultStream().collect(Collectors.toList());
    }
}
