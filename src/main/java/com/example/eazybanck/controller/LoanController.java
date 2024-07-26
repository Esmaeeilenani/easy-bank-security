package com.example.eazybanck.controller;

import com.example.eazybanck.model.Loans;
import com.example.eazybanck.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("loans")
public class LoanController {

    private final LoanRepository loanRepository;

    @GetMapping
    public ResponseEntity<List<Loans>> getLoans(@RequestParam long id){
        return ResponseEntity.ok(loanRepository.findByCustomerIdOrderByStartDtDesc(id));
    }
}
