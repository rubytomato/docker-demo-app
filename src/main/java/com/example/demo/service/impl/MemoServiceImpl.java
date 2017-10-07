package com.example.demo.service.impl;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;
import com.example.demo.service.MemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MemoServiceImpl implements MemoService {

    private MemoRepository repository;

    @Autowired
    public MemoServiceImpl(MemoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Memo findById(Long id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Memo> findAll(Pageable page) {
        return repository.findAll(page);
    }

}
