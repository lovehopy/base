package com.example.jpa_hjkim.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Column {
    private String data;
    private String name;
    private boolean searchable;
    private boolean orderable;
    private HashMap<DataTablesInput.SearchCriterias, String> search;
}
