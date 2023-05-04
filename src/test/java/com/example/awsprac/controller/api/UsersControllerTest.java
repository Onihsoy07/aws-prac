package com.example.awsprac.controller.api;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
class UsersControllerTest {

//    @Autowired
//    private UsersService usersService;

    @Mock
    private UsersService usersService;

//    @Autowired
//    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users().builder()
            .username("aa")
            .password("aa")
            .phone_number("11")
            .build());
        usersList.add(new Users().builder()
            .username("bb")
            .password("bb")
            .phone_number("22")
            .build());
        usersList.add(new Users().builder()
            .username("cc")
            .password("acca")
            .phone_number("112")
            .build());
//
//        System.out.println("--------------------------------------");
//        System.out.println(usersList);


//        given(usersService.fildAll()).willReturn(usersList);
//        mockMvc.perform(
//            get("/user"))
//            .andExpect(status().isOk())
//            .andDo(print());
    }
}