package com.example.awsprac.service;

import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.dto.UsersJoinDto;
import com.example.awsprac.domain.dto.UsersUpdateDto;
import com.example.awsprac.domain.entity.Users;
import java.util.List;

public interface UsersService {

    List<UsersDto> fildAll();

    UsersDto findById(Long id);

    UsersDto sava(UsersJoinDto usersJoinDto);

    UsersDto update(Long id, UsersUpdateDto usersUpdateDto);

}
