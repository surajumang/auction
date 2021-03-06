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
package com.orange.auction.dto;

import lombok.Data;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Data
public class JSONWrapper {
    private String value;

    public JSONWrapper(String value) {
        this.value = value;
    }

    public static JSONWrapper create(String value){
        return new JSONWrapper(value);
    }
}
