package com.example.jpa_hjkim.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    public void getName(){
        final Member member = Member.builder()
                .name("테스트")
                .age(111)
                .hobby("테스트")
                .build();
        assertEquals("테스트",member.getName());
    }

    @Test
    public void getId(){
        final Member member = Member.builder()
                .name("테스트")
                .age(111)
                .hobby("테스트")
                .build();
        assertEquals("테스트",member.getId());
    }

}
