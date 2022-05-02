package com.example.jpa_hjkim.entity;

import lombok.*;

@Data
@NoArgsConstructor
public class MemberResult {
    private Long id;
    private String name;
    private Integer age;
    private String hobby;
}
