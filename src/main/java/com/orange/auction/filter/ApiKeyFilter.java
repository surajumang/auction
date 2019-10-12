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
package com.orange.auction.filter;

import com.orange.auction.model.ApiKey;
import com.orange.auction.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    public static final String HEADER_API_KEY = "api-key";
    @Autowired
    private ApiKeyService apiKeyService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader(HEADER_API_KEY);
        if (isVisitorRequest(request.getRequestURI()) ||
                isValidApiKeyPresent(request.getHeader(HEADER_API_KEY))){
            filterChain.doFilter(request, response);
            return;
        }
        response.setStatus(403);
        response.getWriter().println("{ \"data\": \"Unauthorized\"}");
    }

    private boolean isValidApiKeyPresent(String apiKey){
        if (StringUtils.isEmpty(apiKey)){
            return false;
        }
        Optional<Boolean> val = apiKeyService.getApiKey(apiKey).map(apiKeyService::isExpired);
        return val.isPresent() && !val.get();
    }

    private boolean isVisitorRequest(String uri){
        return uri.contains("/visitor/");
    }
}
