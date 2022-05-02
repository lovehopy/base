package com.example.jpa_hjkim.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
* hjkim
* 모두 필수데이터로 Builder로 생성
* */
@AllArgsConstructor
@Getter @Setter
@Builder
public class DataTablesOutput {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<?> data;
}

