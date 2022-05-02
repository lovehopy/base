package com.example.jpa_hjkim.service;

import com.example.jpa_hjkim.entity.Member;
import com.example.jpa_hjkim.repository.MemberQueryDSLRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryDSLServiceImpl implements QueryDSLService {

    private final MemberQueryDSLRepository memberQueryDSLRepository;

    public QueryDSLServiceImpl(MemberQueryDSLRepository memberQueryDSLRepository) {
        this.memberQueryDSLRepository = memberQueryDSLRepository;
    }

    @Override
    public List<Member> findAll(){
        return memberQueryDSLRepository.getMemberAll();
    }

    @Override
    public Page<Member> getMemberAllbyPage(Pageable pageable){
        return memberQueryDSLRepository.getMemberAllbyPage(pageable);
    }
}
