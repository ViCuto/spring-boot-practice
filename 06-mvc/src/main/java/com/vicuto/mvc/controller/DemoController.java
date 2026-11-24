package com.vicuto.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class DemoController {

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("date", LocalDate.now());
        return "hello";
    }

}
