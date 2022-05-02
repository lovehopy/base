package com.example.jpa_hjkim.service;

import com.example.jpa_hjkim.entity.MemberResult;

import java.util.HashMap;
import java.util.List;

public interface MainSevice {
    List<MemberResult> getMemberAll(HashMap<String,Object> cond) throws Exception;
    Integer getMemberAllTotal(HashMap<String,Object> cond);
}
