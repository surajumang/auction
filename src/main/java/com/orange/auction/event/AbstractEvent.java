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
package com.orange.auction.event;

/**
 * Created 10/8/2019
 *
 * @author sjkumar
 */
public abstract class AbstractEvent implements Event {
    private final String name;
    private final Long memberId;

    public AbstractEvent(String name, Long memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "AbstractEvent{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
