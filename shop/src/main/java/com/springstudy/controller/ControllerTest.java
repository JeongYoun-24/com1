package com.springstudy.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class ControllerTest {

    @GetMapping("/hello")
    public void hello(Model model){

        log.info("/hello 요청중");
        model.addAttribute("msg","HELLO WRRLD");

    }
}
