package com.example.eazybanck.controller;

import com.example.eazybanck.model.Accounts;
import com.example.eazybanck.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountsRepository accountsRepository;

    @GetMapping
    public ResponseEntity<Accounts> getAccounts(@RequestParam long id) {
        return ResponseEntity.ofNullable(accountsRepository.findByCustomerId(id));
    }


}
