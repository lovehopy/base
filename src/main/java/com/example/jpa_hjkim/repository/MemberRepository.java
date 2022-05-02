package com.example.jpa_hjkim.repository;

import com.example.jpa_hjkim.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Page<Member> findByNameContains(String name, Pageable pageable);
}
