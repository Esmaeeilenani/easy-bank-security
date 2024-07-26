package com.example.eazybanck.controller;

import com.example.eazybanck.model.Contact;
import com.example.eazybanck.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RequiredArgsConstructor
@RestController
@RequestMapping("contacts")
public class ContactController {

    private final ContactRepository contactRepository;


    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok(contactRepository.save(contact));
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        return "SR" + (random.nextInt(999999999 - 9999) + 9999);
    }
}
