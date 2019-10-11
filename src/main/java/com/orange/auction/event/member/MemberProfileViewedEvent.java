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
package com.orange.auction.event.member;

import com.orange.auction.event.AbstractEvent;

/**
 * Created 10/8/2019
 *
 * @author sjkumar
 */
public class MemberProfileViewedEvent extends AbstractEvent {

    public static final String EVENT_NAME = "MEMBER_PROFILE_VIEWED_EVENT";

    private final Long viewedMemberId;

    public MemberProfileViewedEvent(Long memberId, Long viewedMemberId) {
        super(EVENT_NAME, memberId);
        this.viewedMemberId = viewedMemberId;
    }
}
