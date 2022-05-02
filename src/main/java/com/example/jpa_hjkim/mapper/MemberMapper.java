package com.example.jpa_hjkim.mapper;

import com.example.jpa_hjkim.entity.MemberResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberResult> getMemberAll(HashMap<String,Object> cond);
    Integer getMemberAllTotal(HashMap<String,Object> cond);
}
