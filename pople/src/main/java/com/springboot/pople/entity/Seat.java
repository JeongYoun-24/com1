package com.springboot.pople.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    private Long seat_code;
    private String seat_number;
    private boolean seat_status;
    @ManyToOne(fetch = FetchType.LAZY)
    private TimeTable timeTable;

}
