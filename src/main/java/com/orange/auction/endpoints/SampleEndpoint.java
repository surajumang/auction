package com.orange.auction.endpoints;

import com.orange.auction.model.Member;
import com.orange.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SampleEndpoint {
    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private UserService userService;

    @GetMapping("/users/{email}")
    public Member sayHello(
            @PathVariable("email")String email){
        logger.info("Email recieved is " + email);
        return userService.getUser(email);
    }

    @GetMapping("/users")
    public List<Member> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Member> addUser(@RequestBody Member member){
        userService.addUser(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
