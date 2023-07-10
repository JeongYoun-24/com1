package com.springstudy.shop.service;

import com.springstudy.shop.dto.BoardDto;
import com.springstudy.shop.dto.PageRequestDTO;
import com.springstudy.shop.dto.PageResponseDTO;
import com.springstudy.shop.entity.Board;
import com.springstudy.shop.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public PageResponseDTO<BoardDto> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        // 레포지토리에서 entity데이터 추출
        Page<Board> result = boardRepository.search2(types,keyword,pageable);
        // entity -> dto
        List<BoardDto> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board,BoardDto.class))
                .collect(Collectors.toList());


        return PageResponseDTO.<BoardDto>widthAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }


}
