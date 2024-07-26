package com.example.eazybanck.controller;

import com.example.eazybanck.model.Cards;
import com.example.eazybanck.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cards")
public class CardController {
    private final CardsRepository cardsRepository;

    @GetMapping
    public ResponseEntity<List<Cards>> getCards(@RequestParam long id) {
        return ResponseEntity.ok(cardsRepository.findByCustomerId(id));
    }

}
