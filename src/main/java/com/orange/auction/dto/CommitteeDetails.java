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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.MonthDay;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Data
public class CommitteeDetails {
    @NotNull
    @Positive
    private Long ownerId;
    private String ownerFirstName;
    //ID of this committee, to be used while showing the details.
    private Long id;
    private Integer numberOfMembers = 0;
    @NotNull
    @Positive
    private Integer tenure;
    @NotNull
    @Positive
    private Long amount;
    @NotNull
    @Positive
    private Integer bidDate;
}
/*
 {
     "ownerId" : 3,
     "tenure": 12,
     "amount" : 20000,
     "bidDate" : 5
  }
* */