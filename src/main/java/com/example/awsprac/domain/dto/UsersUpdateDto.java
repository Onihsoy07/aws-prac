package com.example.awsprac.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersUpdateDto {

    @NotBlank(message = "password를 입력하세요")
    @Size(min = 6, max = 50, message = "password의 길이가 이상합니다.")
    private String password;

    private String phone_number;

}
