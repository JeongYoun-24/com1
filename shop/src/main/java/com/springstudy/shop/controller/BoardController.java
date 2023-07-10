package com.springstudy.shop.controller;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.dto.PageRequestDTO;
import com.springstudy.shop.dto.PageResponseDTO;
import com.springstudy.shop.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController  {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<BoardDto> responseDTO = boardService.list(pageRequestDTO);

        log.info(responseDTO);
        model.addAttribute("responseDTO",responseDTO);
        // return 포워딩 생략시 => url와 동일하게 지정
        // return "board/list"; 인식

    }

}
