package com.example.awsprac.service.impl;

import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.domain.repository.UsersRepository;
import com.example.awsprac.service.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<Users> fildAll() {
        return usersRepository.findAll();
    }
}
