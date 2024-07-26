package com.example.eazybanck.controller;

import com.example.eazybanck.model.AccountTransactions;
import com.example.eazybanck.repository.AccountTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("balances")
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping
    public ResponseEntity<List<AccountTransactions>> getAccountTransactions(@RequestParam long id) {
        return ResponseEntity.ok(accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id));

    }
}
