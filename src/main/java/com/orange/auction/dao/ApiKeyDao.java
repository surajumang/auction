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

import java.util.Optional;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
public interface ApiKeyDao {
    Optional<ApiKey> getApiKey(String apiKey);
}
