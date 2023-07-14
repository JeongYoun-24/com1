package com.springboot.movei;

import com.springboot.pople.PopleApplication;
import com.springboot.pople.entity.Movie;
import com.springboot.pople.entity.Users;
import com.springboot.pople.repository.MovieRepository;
import com.springstudy.shop.entity.Item;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest(classes = PopleApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class MovieTest {


    @Autowired
    private MovieRepository movieRepository;


    @Test
    @DisplayName("Movie 영화 insert테스트")
    public void testInsert222() {
//        IntStream.rangeClosed(3, 5).forEach(i -> {
            // 객체 생성
        Movie movie = Movie.builder()
                    .movie_code(5L)
                    .movie_name("범죄도시3" )
                    .movie_poster("jpg")
                    .movie_summary("이때까지 이런 영화는 없었다 ㅇㅈ?")
                    .movie_time("188분")
                    .movei_Rating("15세이상")
                    .movie_date("7/30")
                    .movie_status(false)
                    .build();

            // 영속성 컨텍스트에 반영
            Movie result = movieRepository.save(movie);

//        });

    }


    @Test
    @DisplayName("Movie 영화 조회 테스트 ")
    public void testselect(){

        List<Movie> movieList = movieRepository.findAll();
        movieList.forEach(item -> {
            log.info(item);
        });

    }

    @Test
    @DisplayName("Movie 영화 수정  테스트 ")
    public void testupdate(){

        Long movie_code = 1L;
        Optional<Movie> item_result = movieRepository.findById(movie_code);
        Movie movie = item_result.orElseThrow();

        movie.change("영화 이름 수정 ", "영화 이미지 수정","영화 줄거리 수정 ");
        movieRepository.save(movie);

        List<Movie> itemList = movieRepository.findAll();
        itemList.forEach(vo ->{
            log.info(vo);
        });

    }


    @Test
    @DisplayName("Movie 영화 삭제 테스트 ")
    public void testdelete(){
        Long movie_code = 5L;
        movieRepository.deleteById(movie_code);

    }





}
