package com.springstudy.shop.service;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.entity.Board;
import com.springstudy.shop.repository.BoardRepository;
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
public class BoardServiceImpl implements BoardService {

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;


    @Override
    public Long register(BoardDto boardDto) {
        // dto-> entity로 데이터 복사
        Board board = modelMapper.map(boardDto,Board.class);
        Long bno = boardRepository.save(board).getBno();


        return bno;
    }

    @Override
    public BoardDto readOne(Long bno) { //
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        BoardDto boardDto = modelMapper.map(board,BoardDto.class);

        return boardDto;
    }

    @Override
    public void modify(BoardDto boardDto) {

        Optional<Board> result =  boardRepository.findById(boardDto.getBno());
        Board board = result.orElseThrow();

        board.change(boardDto.getTitle(),boardDto.getContent());
        boardRepository.save(board);


    }

    @Override
    public void remove(Long bno) {

        boardRepository.deleteById(bno);


    }


}
