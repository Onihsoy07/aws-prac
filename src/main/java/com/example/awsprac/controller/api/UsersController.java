package com.example.awsprac.controller.api;

import com.example.awsprac.domain.dto.ResponseDto;
import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.service.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/user")
    public ResponseDto<List<UsersDto>> findAll() {
        return new ResponseDto<>(HttpStatus.OK.value(), usersService.fildAll());
    }

    @GetMapping("/user/{id}")
    public ResponseDto<UsersDto> findById(@PathVariable final Long id) {
        return new ResponseDto<>(HttpStatus.OK.value(), usersService.findById(id));
    }
//
//    @PostMapping("/user")
//    public void save(String username, String password, String phone_number) {
//
//
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void delete(@PathVariable final Long id) {
//
//
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void update(@PathVariable final Long id, String password, String phone_number) {
//
//
//    }

}
