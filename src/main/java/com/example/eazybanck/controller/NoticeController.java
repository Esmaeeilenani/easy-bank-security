package com.example.eazybanck.controller;

import com.example.eazybanck.model.Notice;
import com.example.eazybanck.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("notices")
public class NoticeController {

    private final NoticeRepository noticeRepository;

    @GetMapping
    public ResponseEntity<List<Notice>> getNotices(){
        return ResponseEntity.ok(noticeRepository.findAllActiveNotices());
    }
}
