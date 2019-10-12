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
package com.orange.auction.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Entity
@Data
public class ApiKey {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "API_KEY")
    private String apiKey;
    @Column(name="CLIENT")
    private String client;
    @Column(name="VALID_UNTIL")
    private LocalDateTime validUntil;
}

