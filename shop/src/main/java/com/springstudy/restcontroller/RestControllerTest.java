package com.springstudy.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {

    @GetMapping(value = "/test")
    public String helloWorldtest(){

        return "wwe23";
    }

}
