package com.springboot.pople.dto;

import com.springboot.pople.entity.Movie;
import com.springboot.pople.entity.TimeTable;
import com.springboot.pople.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicktingDTO {

    private Long tickting_code;  //영화 내역 번호
    private Long tickting_count;  // 예약 인원수
    private String seat_number; // 예약좌석 번호
    private LocalDateTime tickting_date;
    private Long movie_code;  // 영화 번호
    private String user_id; // 회원 아이디
    private Long timetable_code;  // 영화 상영 시간 번호


}







