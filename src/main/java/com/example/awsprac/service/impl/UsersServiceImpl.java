package com.example.awsprac.service.impl;

import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.dto.UsersJoinDto;
import com.example.awsprac.domain.dto.UsersUpdateDto;
import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.domain.mapping.UsersMapping;
import com.example.awsprac.domain.repository.UsersRepository;
import com.example.awsprac.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsersDto> fildAll() {
        List<Users> usersList = usersRepository.findAll();
        List<UsersDto> usersDtoList = new ArrayList<>();
        for(Users users : usersList) {
            usersDtoList.add(UsersMapping.convertToDto(users));
        }
        return usersDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public UsersDto findById(Long id) {
        throw new IllegalArgumentException("에러에레ㅓㅇ러ㅔ");
//        return UsersMapping.convertToDto(getUsers(id));
    }

    @Override
    @Transactional
    public UsersDto sava(UsersJoinDto usersJoinDto) {
        Users users = new Users().builder()
            .username(usersJoinDto.getUsername())
            .password(usersJoinDto.getPassword())
            .phone_number(usersJoinDto.getPhone_number())
            .build();
        Users savaUsers = usersRepository.save(users);
        return UsersMapping.convertToDto(savaUsers);
    }

    @Override
    @Transactional
    public UsersDto update(Long id, UsersUpdateDto usersUpdateDto) {
        Users users = getUsers(id);
        users.setPassword(usersUpdateDto.getPassword());
        users.setPhone_number(usersUpdateDto.getPhone_number());
        Users updateUsers = usersRepository.save(users);
        return UsersMapping.convertToDto(updateUsers);
    }

    private Users getUsers(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Users ID : %d 로 찾을 수없습니다.", id));
        });
    }
}
