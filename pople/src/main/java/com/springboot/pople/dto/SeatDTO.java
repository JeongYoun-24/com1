package com.springboot.pople.dto;

import com.springboot.pople.entity.TimeTable;
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
public class SeatDTO {


    private Long seat_code;
    private String seat_number;
    private boolean seat_status;
    private Long timetable_code;




}
