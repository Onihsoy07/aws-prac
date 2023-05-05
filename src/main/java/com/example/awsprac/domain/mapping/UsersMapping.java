package com.example.awsprac.domain.mapping;

import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.entity.Users;

public class UsersMapping {

    public static UsersDto convertToDto(Users users) {
        UsersDto dto = new UsersDto().builder()
            .id(users.getId())
            .username(users.getUsername())
            .password(users.getPassword())
            .phone_number(users.getPhone_number())
            .build();
        return dto;
    }

    public static Users convertToModel(UsersDto usersDto) {
        Users users = new Users().builder()
            .id(usersDto.getId())
            .username(usersDto.getUsername())
            .password(usersDto.getPassword())
            .phone_number(usersDto.getPhone_number())
            .build();
        return users;
    }

}
