package com.springstudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 2000,nullable = false)
    private String content;
    @Column(length = 50,nullable = false)
    private String writer;


}
