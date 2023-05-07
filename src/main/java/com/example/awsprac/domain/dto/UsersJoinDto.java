package com.example.awsprac.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersJoinDto {

    @NotNull(message = "username 키가 없습니다.")
    @NotBlank(message = "username 값이 없습니다.")
    @Size(min = 6, max = 20, message = "username 길이가 이상합니다.")
    private String username;

    @NotNull(message = "password 키가 없습니다.")
    @NotNull(message = "password 값이 없습니다.")
    @Size(min = 6, max = 20, message = "password 길이가 이상합니다.")
    private String password;

    private String phone_number;

}
