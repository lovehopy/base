package com.example.jpa_hjkim.service;

import com.example.jpa_hjkim.entity.MemberResult;
import com.example.jpa_hjkim.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MainSeviceImpl implements MainSevice{

    private final MemberMapper memberMapper;

    public MainSeviceImpl(MemberMapper memberMybatisRepository) {
        this.memberMapper = memberMybatisRepository;
    }

    @Override
    public List<MemberResult> getMemberAll(final HashMap<String,Object> cond) throws Exception{
         return memberMapper.getMemberAll(cond);
    }

    @Override
    public Integer getMemberAllTotal(final HashMap<String,Object> cond) {
        return memberMapper.getMemberAllTotal(cond);
    }

}
