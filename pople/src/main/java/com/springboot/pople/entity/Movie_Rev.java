package com.springboot.pople.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movie_Rev")
public class Movie_Rev {

    @Id
    private Long rev_no;
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @Column(nullable = false,length = 500)
    private String rev_title;
    @Column(nullable = false,length = 1000)
    private String rev_content;
    private LocalDateTime rev_date;




}
