package com.example.awsprac.service.impl;

import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.domain.mapping.UsersMapping;
import com.example.awsprac.domain.repository.UsersRepository;
import com.example.awsprac.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<UsersDto> fildAll() {
        List<Users> usersList = usersRepository.findAll();
        List<UsersDto> usersDtoList = new ArrayList<>();
        for(Users users : usersList) {
            usersDtoList.add(UsersMapping.convertToDto(users));
        }
        return usersDtoList;
    }

    @Override
    public UsersDto findById(Long id) {
        return UsersMapping.convertToDto(getUsers(id));
    }

    private Users getUsers(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Users ID : %d 로 찾을 수없습니다.", id));
        });
    }
}
