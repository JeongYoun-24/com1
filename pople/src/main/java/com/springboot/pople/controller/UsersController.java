package com.springboot.pople.controller;

import com.springboot.pople.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/modify")
    public String modifypage(Model model){



        return "users/modify";
    }

    @PostMapping("/users/modify")
    public String modifyDate(Model model){



        return "views/main";
    }



}
