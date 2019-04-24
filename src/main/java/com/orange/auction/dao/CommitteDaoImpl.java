package com.orange.auction.dao;

import com.orange.auction.model.Committee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommitteDaoImpl implements CommitteeDao {

    private final EntityManager entityManager;

    public CommitteDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Committee getById(Long id) {
        return null;
    }

    @Override
    public void add(Committee committee) {

    }

    @Override
    public List<Committee> getAll() {
        return null;
    }
}
