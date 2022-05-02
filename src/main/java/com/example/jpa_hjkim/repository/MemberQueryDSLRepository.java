package com.example.jpa_hjkim.repository;

import com.example.jpa_hjkim.entity.Member;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpa_hjkim.entity.QMember.member;

@Repository
public class MemberQueryDSLRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberQueryDSLRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Member> getMemberAll(){
        return jpaQueryFactory
                .selectFrom(member)
                .fetch();
    }

    public Page<Member> getMemberAllbyPage(Pageable pageable){
        JPAQuery<Member> query = jpaQueryFactory
                .selectFrom(member)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        List<Member> content = query.fetch();

        JPAQuery<Long> totalQuery = jpaQueryFactory
                .select(member.count()).from(member);

        /* PageableExecutionUtils.getPage는 PageImpl과 같은 역할을 하지만
        마지막 인자로 함수를 전달하는데 내부 작동에 의해서 토탈카운트가 페이지사이즈 보다 적거나 ,
        마지막페이지 일 경우 해당 함수를 실행하지 않는다 쿼리를 조금더 줄일 수 있다 .*/
        return PageableExecutionUtils.getPage(content, pageable, ()->totalQuery.fetchOne());
    }

}
