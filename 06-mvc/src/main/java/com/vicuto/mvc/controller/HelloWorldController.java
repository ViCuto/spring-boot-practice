package com.vicuto.mvc.controller;

//import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hello-world";
    }

/*
    @RequestMapping("/processFormMessage") // also @GetMapping
    public String getMessage(HttpServletRequest httpServletRequest, Model model) {
        String name = httpServletRequest.getParameter("studentName");

        model.addAttribute("message", "HELLO " + name.toUpperCase());
        return "hello-world";
    }
*/

    @PostMapping("/processFormMessage")
    public String getMessage(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message", "HELLO AGAIN " + name.toUpperCase());
        return "hello-world";
    }

}
