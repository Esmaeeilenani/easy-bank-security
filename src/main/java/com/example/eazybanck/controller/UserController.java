package com.example.eazybanck.controller;

import com.example.eazybanck.model.Customer;
import com.example.eazybanck.model.LoginRequest;
import com.example.eazybanck.model.LoginResponse;
import com.example.eazybanck.service.CustomerService;
import com.example.eazybanck.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class UserController {

    private final CustomerService customerService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        return customerService.registerNewCustomer(customer);

    }

    @GetMapping("/user")
    public ResponseEntity<Customer> login(Authentication authentication) {
        return ResponseEntity.ok(customerService.findByEmail(authentication.getName()).orElse(null));
    }


    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String jwt = null;
        Authentication authentication = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequest.username(), loginRequest.password());
        Authentication authenticate = authenticationManager.authenticate(authentication);

        if (authenticate == null) {
            jwt = JwtUtils.generateJWT(authentication);
        }


        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION,jwt)
                .body(new LoginResponse(HttpStatus.OK.getReasonPhrase(),jwt));
    }


}
