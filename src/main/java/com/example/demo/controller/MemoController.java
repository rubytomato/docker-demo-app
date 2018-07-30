package com.example.demo.controller;

import com.example.demo.entity.Memo;
import com.example.demo.service.MemoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "memo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MemoController {

    private MemoService service;

    public MemoController(MemoService service) {
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Memo> memo(@PathVariable(value = "id") Long id) {
        Memo memo = service.findById(id);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @GetMapping(path = "list")
    public ResponseEntity<List<Memo>> list(Pageable page) {
        Page<Memo> memos = service.findAll(page);
        return new ResponseEntity<>(memos.getContent(), HttpStatus.OK);
    }

}
