/*
 * Copyright 2006-2019 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package com.orange.auction.dao;

import com.orange.auction.model.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Transactional
@Repository
public class ApiKeyDaoImpl implements ApiKeyDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<ApiKey> getApiKey(String apiKey) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<ApiKey> criteriaQuery = criteriaBuilder.createQuery(ApiKey.class);
        Root<ApiKey> root = criteriaQuery.from(ApiKey.class);

        Predicate eqPredicate = criteriaBuilder.equal(root.get("apiKey"), apiKey);
        criteriaQuery.where(eqPredicate);
        ApiKey value = entityManager.createQuery(criteriaQuery).getSingleResult();
        return value == null ? Optional.empty() : Optional.of(value);
    }
}
