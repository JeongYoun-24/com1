package com.springstudy.shop.service.uesrs;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.dto.UsersDTO;

public interface UsersService {


    public String register(UsersDTO usersDTO);
    public UsersDTO readOne(String user_id);
    public void modify(UsersDTO usersDTO);
    public void remove(String user_id);

    //PageRespnesDTO


}
