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
package com.orange.auction.service;

import com.orange.auction.dao.CommitteeDao;
import com.orange.auction.model.Committee;
import com.orange.auction.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@Service
public class CommitteeServiceImpl implements CommitteeService {
    @Autowired
    private CommitteeDao committeeDao;

    @Override
    public void addNewCommittee(Committee committee) {
        committeeDao.addNewCommittee(committee);
    }

    @Override
    public Committee getCommittee(Long id) {
        return committeeDao.getCommittee(id).orElseThrow(EntityNotFoundException::new);
    }

    //add 'member' to committee with given 'id'
    @Override
    public void addMember(Long id, Member member) {
        Committee committee = getCommittee(id);
        committee.getParticipants().add(member);
        committeeDao.updateCommittee(committee);
    }

    @Override
    public void update(Committee committee) {
        committeeDao.updateCommittee(committee);
    }
}
