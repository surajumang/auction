package com.orange.auction.endpoints;

import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberEndpoint {

    @Autowired
    private MemberService memberService;

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

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member){
        memberService.addUser(member);
        return ResponseEntity.ok("Member added");
    }
}
