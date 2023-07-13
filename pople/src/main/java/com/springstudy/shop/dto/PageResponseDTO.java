package com.springstudy.shop.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    private int start; // 시작 페이지 번호
    private int end ; // 끝 페이지 번호

    private int prev; // 이전 페이지 존재 여부
    private int next; // 다음 페이지 존재 여부

    private List<E> dtoList;

    // 메서드

}
