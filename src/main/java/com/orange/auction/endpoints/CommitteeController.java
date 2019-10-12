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
package com.orange.auction.endpoints;

import com.orange.auction.dto.CommitteeDetails;
import com.orange.auction.dto.JSONWrapper;
import com.orange.auction.model.Committee;
import com.orange.auction.model.Member;
import com.orange.auction.service.CommitteeService;
import com.orange.auction.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

/**
 * Created 10/12/2019
 *
 * @author sjkumar
 */
@RestController
@RequestMapping("/committees")
public class CommitteeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommitteeService committeeService;
    @Autowired
    private MemberService memberService;

    //addNewCommittee and view a specific single committee.
    @PostMapping("/add")
    public ResponseEntity<CommitteeDetails> addNewCommittee(@Valid @RequestBody CommitteeDetails committeeDetails){
        Committee committee = modelMapper.map(committeeDetails, Committee.class);
        Member member = memberService.getById(committeeDetails.getOwnerId());
        committee.setOwner(member);
        committeeService.addNewCommittee(committee);
        return ResponseEntity.ok(modelMapper.map(committee, CommitteeDetails.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommitteeDetails> getCommittee(@PathVariable("id") Long id){
        Committee committee = committeeService.getCommittee(id);
        CommitteeDetails committeeDetails = modelMapper.map(committee, CommitteeDetails.class);

        committeeDetails.setNumberOfMembers(committee.getParticipants().size());
        return ResponseEntity.ok(committeeDetails);
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity<JSONWrapper> editCommittee(@PathVariable("id") Long id,
                                                     @RequestBody CommitteeDetails committeeDetails){
        Committee committee = committeeService.getCommittee(id);
        modelMapper.map(committeeDetails, committee);
        committeeService.update(committee);
        return ResponseEntity.ok(JSONWrapper.create("Committee details updated"));
    }

    //adds a member to the committee

    @PostMapping("/{id}/add/{memberId}")
    public ResponseEntity<JSONWrapper> addMemberToCommittee(@PathVariable("id") Long id,
                                                            @PathVariable("memberId") Long memberId){
        Member member = memberService.getById(memberId);
        committeeService.addMember(id, member);
        return ResponseEntity
                .ok(JSONWrapper
                        .create(String.format("Member %d added to committee %d", memberId, id)));
    }
}
