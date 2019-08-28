package com.oocl.web.sampleWebApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    private static List<User> users = new ArrayList(){{
        add(new User("001","xiaoming"));
       // add(new User("002","xiaohong"));
    }};


    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> queryUser() {
        return ResponseEntity.ok(users);
    }
    @PutMapping
    public ResponseEntity<List<User>> updateUser() {
        return ResponseEntity.ok(users);
    }
}
