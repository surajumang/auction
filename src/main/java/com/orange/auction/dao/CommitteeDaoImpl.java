package com.orange.auction.dao;

import com.orange.auction.model.ApiKey;
import com.orange.auction.model.Committee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CommitteeDaoImpl implements CommitteeDao {

    private final EntityManager entityManager;

    public CommitteeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Committee> getCommittee(Long id) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Committee> criteriaQuery = criteriaBuilder.createQuery(Committee.class);
        Root<Committee> root = criteriaQuery.from(Committee.class);

        Predicate eqPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(eqPredicate);

        try {
            return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public void addNewCommittee(Committee committee) {
        entityManager.persist(committee);
    }

    @Override
    public List<Committee> getAll() {
        return null;
    }

    @Override
    public void updateCommittee(Committee committee) {
        entityManager.merge(committee);
    }
}
