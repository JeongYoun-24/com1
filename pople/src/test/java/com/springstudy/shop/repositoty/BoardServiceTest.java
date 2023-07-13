package com.springstudy.shop.repositoty;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@Log4j2
@TestPropertySource(locations = "classpath:application.properties")
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("Service 객체 확인 테스트 ")
    public void RegosterTset(){
//        log.info(boardService.getClass().getName());

        BoardDto boardDto = BoardDto.builder()
                .title("Sample title")
                .content("Sampl content")
                .writer("Sample user ")
                .build();
        Long bno =  boardService.register(boardDto);
        log.info("register bno : "+bno);


    }
    @Test
    @DisplayName("Select ReadOne 테스트 ")
    public void SelectTset(){
        Long bno = 100L;

        log.info("Board read one"+boardService.readOne(bno));



    }

    @Test
    @DisplayName("modify 테스트")
    public void ModifyTest(){
        BoardDto boardDto = BoardDto.builder()
                .bno(101L)
                .title("Update 101")
                .content("Update 101")
                .build();
        boardService.modify(boardDto);

    }

    @Test
    @DisplayName("modify 테스트")
    public void DeleteTest(){
        Long bno = 101L;

        boardService.remove(bno);

    }




}
