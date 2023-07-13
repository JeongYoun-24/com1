package com.springstudy.shop.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDTO {

    private String user_id;
    private String user_pwd;
    private String user_name;
    private String user_email;
    private String phone;
    private String birthdate;
    private LocalDateTime regdate;
}
