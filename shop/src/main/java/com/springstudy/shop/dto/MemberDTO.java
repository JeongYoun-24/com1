package com.springstudy.shop.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    @NotBlank(message="이름은 필수 입력 값입니다.")
    private String name;
    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;
    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=4,max=16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요")
    private String password;
    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;
}

// NotEmpty: NULL체크 및 문자열의 경우 길이 0인지 검사
// NotBlank: NULL체크 및 문자열의 경우 길이 0 및 빈 문자열(" ")검사
