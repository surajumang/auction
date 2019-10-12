package com.orange.auction.dao;

import com.orange.auction.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Transactional
@Repository
public class MemberDaoImpl implements MemberDao {


    private final EntityManager entityManager;

    public MemberDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member getById(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public Member getUserByEmail(String email){
        entityManager.getCriteriaBuilder().createQuery(Member.class).where();
        return new Member();
    }

    @Override
    public void addUser(Member member) {
        entityManager.persist(member);
    }

    @Override
    public void update(Long id, Member member) {
        Assert.isTrue(Objects.equals(id, member.getId()), "Different Ids");
        entityManager.merge(member);
    }

    /*
    example of
    CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<String> query = builder.createQuery(String.class);
         Root<Employee> root = query.from(Employee.class);
         query.select(root.get("name"));
         Query<String> q=session.createQuery(query);
         List<String> list=q.getResultList();
     */

    @Override
    public List<Member> getAllUsers() {
        CriteriaQuery<Member> memberCriteriaQuery = entityManager.getCriteriaBuilder().createQuery(Member.class);
        memberCriteriaQuery.select(memberCriteriaQuery.from(Member.class));

        return entityManager.createQuery(memberCriteriaQuery).getResultList();
    }
}
