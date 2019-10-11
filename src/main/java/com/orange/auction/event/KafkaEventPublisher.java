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

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created 10/8/2019
 *
 * @author sjkumar
 */

@Service
public class KafkaEventPublisher {
    // member id to be used as Key, this will ensure that every message corresponding to a member id will be stored
    // in the same partition and hence a strict ordering will be guaranteed.
    @Autowired
    private KafkaTemplate<Long, String> producerTemplate;

    public static final String TOPIC_NAME = "TOPIC_EVENT_LOG";

    public void publishEvent(Event event){
        ProducerRecord<Long, String> eventRecord =
                new ProducerRecord<>(TOPIC_NAME, event.getMemberId(), Event.createData(event));
        producerTemplate.send(eventRecord);
    }
}
