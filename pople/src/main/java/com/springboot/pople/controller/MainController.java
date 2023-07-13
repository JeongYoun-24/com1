package com.springboot.pople.controller;

import com.springboot.pople.dto.UsersDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@Log4j2
@RequestMapping("/*")
public class MainController{




        @GetMapping(value = "/main")
        public String main(  Model model){
            String user_name = "회원";





            return "views/main";
        }
    @GetMapping(value = "index")
    public void indexGET(@SessionAttribute(name = "loginUser", required = false)HashMap<String, Object> map, Model model) {
        log.info("Controller indexGET");

        model.addAttribute("loginUser", map);
    }



}
