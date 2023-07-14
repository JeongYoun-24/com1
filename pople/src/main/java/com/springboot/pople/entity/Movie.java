package com.springboot.pople.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Movie")
public class Movie {  // 영화

    @Id
    @Column(nullable = false)
    private Long movie_code;  // 영화 번호
    @Column(nullable = false,length = 100)
    private String movie_name;  //  양화 제목
    @Column(nullable = false,length = 100)
    private String  movie_poster;  // 영화 이미지 (포스터)
    @Column(nullable = false,length = 1000)
    private String movie_summary; // 영화 줄거리
    @Column(nullable = false,length = 100)
    private String movie_time; // 영화 러닝 타임
    @Column(nullable = false,length = 100)
    private String movei_Rating; // 영화 관람 등급
    private String movie_date;  //   영화 개봉일
    private Boolean movie_status;  // 영화 게시 여부


    public void change(String movie_name,String movie_poster,String movie_summary){
        this.movie_name = movie_name;
        this.movie_poster = movie_poster;
        this.movie_summary = movie_summary;

    }
    public void change2(String movie_date,Boolean movie_status){ //개봉일 및 게시여부 수정
        this.movie_date = movie_date;
        this.movie_status = movie_status;
    }
    public void change2(Boolean movie_status){ // 게시여부 수정
        this.movie_status = movie_status;
    }


}









