package com.springstudy.shop.dto;




import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;
    // block 에대한 시작페이지 번호 ,끝페이지 번호
    private int start; // 시작 페이지 번호
    private int end ; // 끝 페이지 번호

    private boolean prev; // 이전 페이지 존재 여부
    private boolean next; // 다음 페이지 존재 여부

    // 가져올 데이터 저장소
    private List<E> dtoList;

    // 메서드
    @Builder(builderMethodName = "widthAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO ,List<E>dtoList ,int total){
        if (total <= 0)
            return;

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total =total;
        this.dtoList = dtoList;
        // n block에 대한 시작페이지 , 끝 페이지 계산
        // 1~10 => 0.1....1.0 => 1 => 10 -9 => 1
        this.end = (int)(Math.ceil(this.page/10.0))*10;
        this.start = this.end -9;

        // 이전 , 다음 링크 활성화 처리를 위한 계산
        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end > last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * this.size;

    }



}
