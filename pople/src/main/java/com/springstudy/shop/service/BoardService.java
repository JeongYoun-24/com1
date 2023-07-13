package com.springstudy.shop.service;

import com.springstudy.shop.dto.BoardDto;

public interface BoardService {

    public Long register(BoardDto boardDto);
    public BoardDto readOne(Long bno);
    public void modify(BoardDto boardDto);
    public void remove(Long bno);

    //PageRespnesDTO





}
