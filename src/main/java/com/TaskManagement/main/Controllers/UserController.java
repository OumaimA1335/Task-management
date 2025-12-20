package com.TaskManagement.main.Controllers;

import com.TaskManagement.main.Entities.User;
import com.TaskManagement.main.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
