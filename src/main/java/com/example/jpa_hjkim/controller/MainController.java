package com.example.jpa_hjkim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mybatis(Model model){
        model.addAttribute("headLine","project");
        model.addAttribute("subHeadLine","mybatis");
        return "menu/mybatis";
    }

    @GetMapping("/jpa")
    public String jpa(Model model){
        model.addAttribute("headLine","project");
        model.addAttribute("subHeadLine","jpa");
        return "menu/jpa";
    }

    @GetMapping("/querydsl")
    public String querydsl(Model model){
        model.addAttribute("headLine","project");
        model.addAttribute("subHeadLine","querydsl");
        return "menu/querydsl";
    }

    @GetMapping("/kafka")
    public String kafka(Model model){
        model.addAttribute("headLine","project");
        model.addAttribute("subHeadLine","kafka");
        return "menu/kafka";
    }

}
