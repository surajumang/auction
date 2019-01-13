package com.orange.auction.endpoints;

import com.orange.auction.model.User;
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
    public User sayHello(
            @PathVariable("email")String email){
        logger.info("Email recieved is " + email);
        return userService.getUser(email);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
