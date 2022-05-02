package com.example.jpa_hjkim.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/*
* hjkim
* MapperScan 모든 패키지를 mapper로 삼기 위한 설정이 있을수 있으므로 남겨둠
* */
@Configuration
@MapperScan(basePackages = "com.example.jpa_hjkim.mapper")
public class PostgreConfig {
}
