package com.springstudy.shop.repositoty;

import com.springstudy.shop.entity.Board;
import com.springstudy.shop.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@TestPropertySource(locations = "classpath:application.properties")
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("Board insert 테스트")
    public void testImsert(){
        IntStream.rangeClosed(1,100).forEach(i-> {
            // 객체 생성
            Board board = Board.builder()
                    .title("title..."+i)
                    .content("content..."+i)
                    .writer("user"+i)
                    .build();
            // 영속성  컨텍스트에 반영

            Board result = boardRepository.save(board);

            log.info("BNO"+result.getBno());
            log.info("BNO"+result.getTitle());
            log.info("BNO"+result.getContent());
            log.info("BNO"+result.getWriter());



        });

    }

    @Test
    @DisplayName("board select  테스트")
    public void SelectTest(){
//        this.testImsert();
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        log.info(board);

    }


    @Test
    @DisplayName("board update  테스트")
    public void UpdateTest(){

        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        // update 영속성 컨텍스트에 반영
        board.change("update title 100","update content 100");

        boardRepository.save(board);

        log.info(board);

    }
    @Test
    @DisplayName("board delete  테스트")
    public void DleteTest(){

        Long bno = 1L;
        boardRepository.deleteById(bno);


//        log.info(board);

    }


    @Test
    @DisplayName("paginable  테스트")
    public void PageTest(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> resoult = boardRepository.findAll(pageable);


        log.info("total count :"+resoult.getTotalElements());
        log.info("total pages :"+resoult.getTotalPages());
        log.info("page number :"+resoult.getNumber());
        log.info("page size :"+resoult.getSize());

        List<Board> boardListq = resoult.getContent(); // getContent() 데이터 가져오는 메서드

        boardListq.forEach(board -> {log.info(board);});

    }


    @Test
    @DisplayName("user defind Search기능  테스트")
    public void SearchTest(){

        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> resoult = boardRepository.search1(pageable);

        resoult.forEach(board->{log.info(board);});

//        List<Board>boardListq = resoult.getContent(); // getContent() 데이터 가져오는 메서드
//        boardListq.forEach(board -> {log.info(board);});

    }
    @Test
    @DisplayName("Search기능2  테스트")
    public void SearchTest2(){

        String[] types = {"t","c","w"};
        String keyword="1";


        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> resoult = boardRepository.search2(types,keyword,pageable);

        log.info(resoult.getTotalPages());
        log.info(resoult.getSize());
        log.info(resoult.getNumber());
        log.info(resoult.hasPrevious()+":"+resoult.hasNext());


        resoult.forEach(board->{log.info(board);});

//        List<Board>boardListq = resoult.getContent(); // getContent() 데이터 가져오는 메서드
//        boardListq.forEach(board -> {log.info(board);});

    }





}
