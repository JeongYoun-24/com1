package com.springboot.pople.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@Table(name = "Time")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Time {


    @Id
    private Long time_code;  // 상영시간 코드
    @Column(nullable = false ,length = 50)
    private String time;     // 상영 시간


}



