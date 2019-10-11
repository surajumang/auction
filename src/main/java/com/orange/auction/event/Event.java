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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created 10/8/2019
 *
 * @author sjkumar
 */
public interface Event {

    String getName();
    /*
    * This is ID of member whose action triggered the Event*/
    Long getMemberId();

     /* returns the JSON corresponding to this object.
     *  since this logic is not going to change for subclasses, it makes sense to implement it here.*/
    static String createData(Event event){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to convert to JSON" + event);
        }
    }
}
