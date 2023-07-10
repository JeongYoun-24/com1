package com.springstudy.shop.service;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.dto.PageRequestDTO;
import com.springstudy.shop.dto.PageResponseDTO;
import com.springstudy.shop.entity.Board;

public interface BoardService {

    public Long register(BoardDto boardDto);
    public BoardDto readOne(Long bno);
    public void modify(BoardDto boardDto);
    public void remove(Long bno);

    //PageRespnesDTO
    // 클라이언트로 부터 요청한 페이지 정보 처리하야ㅕ 응답하는 메서드
    PageResponseDTO<BoardDto>  list(PageRequestDTO pageRequestDTO);




}
