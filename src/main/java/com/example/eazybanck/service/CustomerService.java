package com.example.eazybanck.service;

import com.example.eazybanck.model.Customer;
import com.example.eazybanck.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerNewCustomer(Customer customer) {

        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customer.setCreateDt(new Date(System.currentTimeMillis()));
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body("user successfully created!");
    }


    public Optional<Customer> findByEmail(String name) {
        return customerRepository.findByEmail(name);
    }

    public Customer loggedInCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return customerRepository.findByEmail(authentication.getName())
                .orElseThrow(()-> new UsernameNotFoundException("not found"));
    }
}
