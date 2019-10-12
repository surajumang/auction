package com.orange.auction.endpoints;

import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SampleEndpoint {
    Logger logger = Logger.getLogger(getClass().getName());

    private final MemberService memberService;

    public SampleEndpoint(MemberService memberService) {
        this.memberService = memberService;
    }

    private static class Message {
		private String message;

		public Message(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

    @GetMapping("/visitor/{greeting}")
    public Message echo(@PathVariable(name = "greeting") String greeting){
        return new Message(greeting);
    }

    @GetMapping("/users/{email}")
    public Member sayHello(
            @PathVariable("email")String email){
        logger.info("Email recieved is " + email);
        return memberService.getUser(email);
    }

    @GetMapping("/users")
    public List<Member> getUsers(){
        return memberService.getUsers();
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> addUser(@RequestBody Member member){
        memberService.addUser(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
