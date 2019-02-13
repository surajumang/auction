package com.orange.auction.dao;

import com.orange.auction.model.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class MemberDaoImpl implements MemberDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member getById(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public Member getUserByEmail(String email){
        String hql = "from MEMBER where EMAIL= :email";
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
        CriteriaQuery<Member> memberCriteriaQuery = entityManager.getCriteriaBuilder().createQuery(Member.class);
        memberCriteriaQuery.select(memberCriteriaQuery.from(Member.class));

        return entityManager.createQuery(memberCriteriaQuery).getResultList();
    }
}
