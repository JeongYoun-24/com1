package com.springboot.pople.dto;

import com.springboot.pople.entity.Cinema;
import com.springboot.pople.entity.Movie;
import com.springboot.pople.entity.Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableDTO {

    private Long timetable_code;
    private String timetable_date;
    private Long time_code;  // 상영시간 코드키
    private long cinama_code; //영화관 코드키
    private Long movie_code;    // 영화 코드 키




}
