package com.springstudy.shop.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.springstudy.shop.entity.Board;
import com.springstudy.shop.entity.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements  BoardSearch {


    public BoardSearchImpl(){
        super(Board.class);
    }


    @Override
    public Page<Board> search1(Pageable pageable) {

        // 작업대상인 Q도메인, JPQL 설정
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        // 조건식 설정
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(board.title.contains("11"));//  title like
        booleanBuilder.or(board.content.contains("11"));

        query.where(booleanBuilder);
        query.where(board.bno.gt(0L));

        // 페이징 처리
        this.getQuerydsl().applyPagination(pageable,query);

        List<Board> list = query.fetch(); // 값 가져오기
        Long conunt  = query.fetchCount(); // 카운터 값 가져오기


        return new PageImpl<>(list,pageable,conunt);
//        return  null;
    }

    @Override
    public Page<Board> search2(String[] types, String keyword, Pageable pageable) {
        // 작업대상인 Q도메인, JPQL 설정
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if(types != null && types.length > 0 && keyword != null) {

            // 조건식 설정
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for(String type: types){
                switch (type){
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }// end swich

            } // end for

            query.where(booleanBuilder);
        } // if

        query.where(board.bno.gt(0L));

        // 페이징 처리
        this.getQuerydsl().applyPagination(pageable,query);

        List<Board> list = query.fetch(); // 값 가져오기
        Long conunt  = query.fetchCount(); // 카운터 값 가져오기

        return new PageImpl<>(list, pageable,conunt);
        /*
        PageImpl을 이용한 Page<T> 반환
        -페이징 처리의 최종 결과는 Page<T> 반환
        -Querydsl에서 처리 하지 않고 JAP에서 처리
        PageImpl(List<T> 데이터, Pagable: 페이지 관련 정보 객체 , Long : 전체 개수 )
         */

    }







}

