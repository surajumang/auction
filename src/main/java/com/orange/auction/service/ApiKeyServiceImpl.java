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
package com.orange.auction.service;

import com.orange.auction.dao.ApiKeyDao;
import com.orange.auction.model.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Service
public class ApiKeyServiceImpl implements ApiKeyService{

    @Autowired
    private ApiKeyDao apiKeyDao;

    @Override
    public Optional<ApiKey> getApiKey(String apiKey) {
        return apiKeyDao.getApiKey(apiKey);
    }

    @Override
    public boolean isExpired(ApiKey apiKey) {
        return apiKey.getValidUntil().isBefore(LocalDateTime.now());
    }
}
