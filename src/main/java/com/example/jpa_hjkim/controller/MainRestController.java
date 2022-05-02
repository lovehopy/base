package com.example.jpa_hjkim.controller;

import com.example.jpa_hjkim.common.Column;
import com.example.jpa_hjkim.common.DataTablesInput;
import com.example.jpa_hjkim.common.DataTablesOutput;
import com.example.jpa_hjkim.entity.Member;
import com.example.jpa_hjkim.entity.MemberResult;
import com.example.jpa_hjkim.repository.MemberRepository;
import com.example.jpa_hjkim.service.MainSevice;
import com.example.jpa_hjkim.service.QueryDSLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class MainRestController {

    private final MemberRepository memberRepository;
    private final MainSevice mainSevice;
    private final QueryDSLService queryDSLService;

    public MainRestController(MemberRepository memberRepository, MainSevice mainSevice, QueryDSLService queryDSLService) {
        this.memberRepository = memberRepository;
        this.mainSevice = mainSevice;
        this.queryDSLService = queryDSLService;
    }

    @PostMapping("/select")
    public ResponseEntity<?> select(@RequestBody DataTablesInput params) throws Exception {
        HashMap<String, Object> cond = new HashMap<>();
        Integer limit = params.getLength();
        Integer offset = Long.valueOf(params.getStart()).intValue();
        log.error("MainRestController.select :::  params [{}]", params);

        cond.put("limit", limit);
        cond.put("offset", offset);

        StringBuilder stringBuilder = new StringBuilder();

        int order_index = 0;
        for(HashMap order : params.getOrder()){
            int index = Integer.parseInt(order.get(DataTablesInput.OrderCriterias.column).toString());
            if(order_index == 0) stringBuilder.append(params.getColumns().get(index).getData() + " " + order.get(DataTablesInput.OrderCriterias.dir));
            else stringBuilder.append(", "+ params.getColumns().get(index).getData() + " " + order.get(DataTablesInput.OrderCriterias.dir));
            log.error("MainRestController.select :::  stringBuilder [{}]", stringBuilder.toString());
            order_index++;
        }
        cond.put("order", stringBuilder.toString());

        for (Column column : params.getColumns()) {
            if (column.getSearch().get("value") != "")
                cond.put(column.getData(), column.getSearch().get(DataTablesInput.SearchCriterias.value).toString());
        }

        List<MemberResult> data = mainSevice.getMemberAll(cond);
        Integer total = mainSevice.getMemberAllTotal(cond);
        DataTablesOutput dataTablesOutput = DataTablesOutput.builder()
                .draw(params.getDraw())
                .recordsFiltered(total)
                .recordsFiltered(total)
                .data(data)
                .build();
        return ResponseEntity.ok(dataTablesOutput);
    }

    @PostMapping("/selectByJpa")
    public ResponseEntity<?> selectByJpa(@RequestBody DataTablesInput params) throws Exception {
        String name = params.getBespokeParams().get("name");
        Integer limit = params.getLength();
        Integer offset = Long.valueOf(params.getStart()).intValue() / limit;
        Pageable pageable = PageRequest.of(offset, limit, Sort.Direction.ASC, "id");
        Page<Member> members = memberRepository.findByNameContains(name, pageable);
        Integer total = Long.valueOf(members.getTotalElements()).intValue();
        DataTablesOutput dataTablesOutput = DataTablesOutput.builder()
                .draw(params.getDraw())
                .recordsFiltered(total)
                .recordsFiltered(total)
                .data(members.getContent())
                .build();
        return ResponseEntity.ok(dataTablesOutput);
    }

    @PostMapping("/selectByQueryDSL")
    public ResponseEntity<?> selectByQueryDSL(@RequestBody DataTablesInput params) throws Exception {
        String name = params.getBespokeParams().get("name");
        Integer limit = params.getLength();
        Integer offset = Long.valueOf(params.getStart()).intValue() / limit;
        Pageable pageable = PageRequest.of(offset, limit, Sort.Direction.ASC, "id");
        Page<Member> members = queryDSLService.getMemberAllbyPage(pageable);
        Integer total = Long.valueOf(members.getTotalElements()).intValue();
        DataTablesOutput dataTablesOutput = DataTablesOutput.builder()
                .draw(params.getDraw())
                .recordsFiltered(total)
                .recordsFiltered(total)
                .data(members.getContent())
                .build();
        return ResponseEntity.ok(dataTablesOutput);
    }
}
