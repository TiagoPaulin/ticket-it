package com.onlycompany.ticketit.controllers;

import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
