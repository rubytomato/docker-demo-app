package com.example.demo.service;

import com.example.demo.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemoService {
    Memo findById(Long id);
    Page<Memo> findAll(Pageable page);
}
