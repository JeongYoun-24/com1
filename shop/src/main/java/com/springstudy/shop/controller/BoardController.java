package com.springstudy.shop.controller;

import com.springstudy.shop.dto.BoardDTO;
import com.springstudy.shop.dto.PageRequestDTO;
import com.springstudy.shop.dto.PageResponseDTO;
import com.springstudy.shop.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);

        // return 포워딩 생략시 => url와 동일하게 지정
        // return "/board/list"; 인식됨
    }


    @GetMapping(value = {"/read","/modify"})
    public void read(Long bno,PageRequestDTO pageRequestDTO, Model model){
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info(boardDTO);
        model.addAttribute("dto",boardDTO);
    }

    @GetMapping("/register")
    public void reisterGet(){
    }

    @PostMapping(value="/register")
    public String registerPost(@Valid BoardDTO boardDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        // post 방식에서 @valid 에서 문제가 발생햇을 때 redirectattribute 객체를 적용하여 데이터전송 (일회용)
        //bindingResult 클래스는 @valid 검증결과에 대한 정보 반환


        if(bindingResult.hasErrors()){
            log.info("board errors ...");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors()); //리다이렉션 시 담을 값
            return "redirect:/board/register";
        }


        Long bno = boardService.register(boardDTO);
        redirectAttributes.addFlashAttribute("result",bno);

        return "redirect:/board/list";   //sendRedirect
    }

    @PostMapping(value="/modify1")
    public String modify(@Valid BoardDTO boardDTO,
                               BindingResult bindingResult,PageRequestDTO pageRequestDTO,
                               RedirectAttributes redirectAttributes){

        // post 방식에서 @valid 에서 문제가 발생햇을 때 redirectattribute 객체를 적용하여 데이터전송 (일회용)
        //bindingResult 클래스는 @valid 검증결과에 대한 정보 반환


        if(bindingResult.hasErrors()){
            log.info("board errors ...");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors()); //리다이렉션 시 담을 값
            redirectAttributes.addAttribute("bno",boardDTO.getBno());

            return "redirect:/board/modify?" + link;
        }


        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result","modifyed");
        redirectAttributes.addAttribute("bno",boardDTO.getBno());
        return "redirect:/board/list";   //sendRedirect
    }

    @PostMapping(value="/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        log.info("remove 접근 : " + bno);

        boardService.remove(bno);

        redirectAttributes.addFlashAttribute("result","removed");

        return "redirect:/board/list";
    }





}
