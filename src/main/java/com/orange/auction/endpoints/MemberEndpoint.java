package com.orange.auction.endpoints;

import com.orange.auction.event.KafkaEventPublisher;
import com.orange.auction.event.member.NewMemberCreatedEvent;
import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(MemberEndpoint.class);

    @Autowired
    private KafkaEventPublisher eventPublisher;
    private final MemberService memberService;

    public MemberEndpoint(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public ResponseEntity<Member> getMemberByEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(memberService.getUser(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id){
        return ResponseEntity.ok(memberService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMember(@RequestBody Member member){
        logger.info("Got a valid request to create a new Member");
        memberService.addUser(member);
        logger.info("Created a new Member "+ member);
        eventPublisher.publishEvent(NewMemberCreatedEvent.create(member.getId(), "API"));
        return ResponseEntity.ok("Member added");
    }
}
