package com.example.jpa_hjkim.service;

import com.example.jpa_hjkim.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryDSLService {
    List<Member> findAll();
    Page<Member> getMemberAllbyPage(Pageable pageable);
}
