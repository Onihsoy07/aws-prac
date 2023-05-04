package com.example.awsprac.controller.api;

import com.example.awsprac.service.UsersService;
import lombok.RequiredArgsConstructor;
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
    public void findAll() {
        usersService.fildAll();
    }

//    @GetMapping("/user/{id}")
//    public void findById(@PathVariable final Long id) {
//
//
//    }
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
