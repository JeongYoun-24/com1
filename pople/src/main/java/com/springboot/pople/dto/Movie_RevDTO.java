package com.springboot.pople.dto;

import com.springboot.pople.entity.Movie;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie_RevDTO {

    private Long rev_no;
    private String user_id;
    private Long movie_code;
    private String rev_title;
    private String rev_content;
    private LocalDateTime rev_date;





}
