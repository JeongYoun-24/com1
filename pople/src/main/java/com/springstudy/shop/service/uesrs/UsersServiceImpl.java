package com.springstudy.shop.service.uesrs;

import com.springstudy.shop.dto.UsersDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class UsersServiceImpl  {
    private final ModelMapper modelMapper;


}
