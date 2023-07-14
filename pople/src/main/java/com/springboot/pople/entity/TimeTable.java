package com.springboot.pople.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TimeTable")
public class TimeTable {

    @Id
    private Long timetable_code;
    private String timetable_date;
    @ManyToOne(fetch = FetchType.LAZY)
    private Time time;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

}
