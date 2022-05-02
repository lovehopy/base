package com.example.jpa_hjkim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberParam {
    private Long id;
    private String name;
    private Integer age;
    private String hobby;
    private Integer limit;
    private Integer offset;
}
