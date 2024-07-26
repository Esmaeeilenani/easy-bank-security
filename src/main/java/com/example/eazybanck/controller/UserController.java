package com.example.eazybanck.controller;

import com.example.eazybanck.model.Customer;
import com.example.eazybanck.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class UserController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        return customerService.registerNewCustomer(customer);

    }

    @GetMapping("/user")
    public ResponseEntity<Customer> login(Authentication authentication) {

        return ResponseEntity.ok(customerService.findByEmail(authentication.getName()).orElse(null));

    }



}
