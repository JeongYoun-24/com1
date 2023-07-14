package com.springboot.pople.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tickting")
public class Tickting {


    @Id
    private Long tickting_code;  //영화 내역 번호
    @Column(nullable = false,length = 10)
    private Long tickting_count;  // 예약 인원수
    @Column(nullable = false,length = 30)
    private String seat_number; // 예약좌석 번호
    private LocalDateTime tickting_date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie; // 영화 번호
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users; // 회원 아이디
    @ManyToOne(fetch = FetchType.LAZY)
    private TimeTable timeTable;  // 영화 상영 시간 번호

}
