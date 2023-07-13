package com.springstudy.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

        @Builder.Default
        private int page = 1;
        @Builder.Default
        private int size =10;

        private String type ; // 검색 타입 t c w tc tw twc
        private String keyword;


        // 메서드


}
