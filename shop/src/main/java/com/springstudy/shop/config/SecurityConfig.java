package com.springstudy.shop.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    // 로그인과정 생략 : 개발자 직접 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        log.info("----- configure ------");

        http.formLogin().loginPage("/members/login") //사용자가 설정한 로그인 페이지
                .defaultSuccessUrl("/")//로그인 성공시 이동 경로
                .usernameParameter("email")//로그인시 사용될 유저 이름
                .failureUrl("/members/login/error")
                .and()//그리고
                .logout() //로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))//로그아웃 경로
                .logoutSuccessUrl("/"); //로그아웃 성공시 이동 경로

        http.csrf().disable();

        //인증되지 않은 사용자가 리소스 요청할 경우 에러
        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        //인가(권한에 대한 접근) 과정 처리
        http.authorizeRequests()
                .mvcMatchers("/bootstrap/**","/js/**","/css/**","/assets/**","/imgs/**",



                        "/","/board/**" ,"/members/**","/item/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest() //인증 과정 요청
                .authenticated(); //리소스 접근 경로 설정 외에는 모두 인증을 요구하도록 설정


        return http.build();
    }

    // 해시코드로 암호화 처리
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 정적자원(resources -> static)들은 스프링시큐리티 적용에서 제외
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        log.info("--0--0-0-0-0-0-0-");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }


}
