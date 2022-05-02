package com.example.jpa_hjkim.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* hjkim
* 생성자가 필요없는 모델 = NoArgsConstructor
* 오로지 GET을 위함 =Getter
* */
@NoArgsConstructor
@Getter
public class DataTablesInput {
    private HashMap<String,String> bespokeParams;
    private int draw;
    private long start;
    private int length;
    private HashMap<SearchCriterias, String> search;
    private List<HashMap<OrderCriterias, String>> order;
    private List<Column> columns;
    public enum SearchCriterias {value, regex}
    public enum OrderCriterias {column, dir}
}
