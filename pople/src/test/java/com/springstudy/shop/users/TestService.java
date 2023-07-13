package com.springstudy.shop.users;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.dto.UsersDTO;
import com.springstudy.shop.service.uesrs.UsersService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@Log4j2
@TestPropertySource(locations = "classpath:application.properties")
public class TestService {

    @Autowired
    private UsersService usersService;

    @Test
    @DisplayName("Service insert 확인 테스트 ")
    public void RegosterTset(){
//        log.info(boardService.getClass().getName());

        UsersDTO usersDTO = UsersDTO.builder()
                .user_id("aaa")
                .user_pwd("1234")
                .user_name("알파")
                .user_email("aaa@naver.com")
                .phone("010-2323-4324")
                .birthdate("19990101")
                .build();
        String user_id =  usersService.register(usersDTO);
        log.info("register user_id : "+user_id);


    }
    @Test
    @DisplayName("Select ReadOne 테스트 ")
    public void SelectTset(){
        String user_id = "aaa";

        log.info("Board read one"+usersService.readOne(user_id));



    }

    @Test
    @DisplayName("modify 테스트")
    public void ModifyTest(){
        UsersDTO boardDto = UsersDTO.builder()
                .user_id("aaa")
                .user_pwd("1234")
                .user_name("알파카")
                .user_email("aaa@naver.com")
                .phone("010-1234-4343")
                .birthdate("19990101")
                .build();
        usersService.modify(boardDto);

    }

    @Test
    @DisplayName("modify 테스트")
    public void DeleteTest(){
        String user_id = "aaa";

        usersService.remove(user_id);

    }







}
