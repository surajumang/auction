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
public class NewMemberCreatedEvent extends AbstractEvent {
    private String enrollmentSource;
    public static final String EVENT_NAME = "NEW_MEMBER_CREATED_EVENT";

    public NewMemberCreatedEvent(Long memberId) {
        super(EVENT_NAME, memberId);
    }

    public static NewMemberCreatedEvent create(Long memberId, String enrollmentSource){
        NewMemberCreatedEvent event = new NewMemberCreatedEvent(memberId);
        event.enrollmentSource = enrollmentSource;
        return event;
    }
}
