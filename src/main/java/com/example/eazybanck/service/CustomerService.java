package com.example.eazybanck.service;

import com.example.eazybanck.model.Customer;
import com.example.eazybanck.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerNewCustomer(Customer customer) {

        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body("user successfully created!");
    }


}
