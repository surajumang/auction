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

import javax.validation.constraints.Pattern;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Data
public class MemberDetails {
    private String email;
    @Pattern(regexp = "[A-Za-z]+", message = "Enter a valid first name")
    private String firstName;
    @Pattern(regexp = "[A-Za-z]+", message = "Enter a valid last name")
    private String lastName;
    @Pattern(regexp = "[0-9]{10}", message = "Enter a valid phone")
    private String phone;
    private String address;
}
