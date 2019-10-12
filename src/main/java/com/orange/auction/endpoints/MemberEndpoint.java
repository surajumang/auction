package com.orange.auction.endpoints;

import com.orange.auction.dto.JSONWrapper;
import com.orange.auction.dto.MemberDetails;
import com.orange.auction.event.KafkaEventPublisher;
import com.orange.auction.event.member.NewMemberCreatedEvent;
import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MemberEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(MemberEndpoint.class);

    @Autowired
    private KafkaEventPublisher eventPublisher;
    @Autowired
    private ModelMapper modelMapper;
    private final MemberService memberService;

    public MemberEndpoint(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public ResponseEntity<Member> getMemberByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(memberService.getUser(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDetails> getMemberById(@PathVariable("id") Long id){
        Member member = memberService.getById(id);
        MemberDetails memberDetails = modelMapper.map(member, MemberDetails.class);
        return ResponseEntity.ok(memberDetails);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<MemberDetails> updateProfile(@PathVariable("id") Long id,
                                                       @RequestBody @Valid MemberDetails memberDetails){
        Member member = memberService.getById(id);
        modelMapper.map(memberDetails, member);
        memberService.update(id, member);
        return ResponseEntity.ok(memberDetails);
    }

    @GetMapping
    public ResponseEntity<List<MemberDetails>> getAllMembers(){
        List<MemberDetails> memberDetails = memberService.getUsers()
                .stream()
                .map( member -> modelMapper.map(member, MemberDetails.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(memberDetails);
    }

    @PostMapping("/add")
    public ResponseEntity<JSONWrapper> addMember(@RequestBody Member member){
        logger.info("Got a valid request to create a new Member");
        memberService.addUser(member);
        logger.info("Created a new Member "+ member);
        eventPublisher.publishEvent(NewMemberCreatedEvent.create(member.getId(), "API"));
        return ResponseEntity.ok(JSONWrapper.create("Member added"));
    }
}
