package com.onlycompany.ticketit.controllers;

import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById (@PathVariable Long id) {

        User user = service.findById(id);

        return ResponseEntity.ok().body(user);

    }

    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj) {

        obj = service.insert(obj);

        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

}
