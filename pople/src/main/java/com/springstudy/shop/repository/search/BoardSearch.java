package com.springstudy.shop.repository.search;

import com.springstudy.shop.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    // 페이지 검색 조회 기능
    Page<Board> search1(Pageable pageable);
    // 페지지 상세 검색 기능 ??
    Page<Board> search2(String[] types,String keyword, Pageable  pageable);

}
