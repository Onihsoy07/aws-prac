package com.example.awsprac.controller.api;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.entity.Users;
import com.example.awsprac.service.UsersService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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

@WebMvcTest(UsersController.class)
class UsersControllerTest {

    @MockBean
    private UsersService usersService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[GET] [findAll] 호출")
    void findAll() throws Exception {
        List<UsersDto> usersList = new ArrayList<>();
        usersList.add(new UsersDto().builder()
            .username("aa")
            .password("aa")
            .phone_number("11")
            .build());
        usersList.add(new UsersDto().builder()
            .username("bb")
            .password("bb")
            .phone_number("22")
            .build());
        usersList.add(new UsersDto().builder()
            .username("cc")
            .password("acca")
            .phone_number("112")
            .build());

        System.out.println(usersList);
        System.out.println("-------------------------------------");

        given(usersService.fildAll()).willReturn(usersList);
        mockMvc.perform(
            get("/user"))
            .andExpect(status().isOk())
//            .andExpect()
            .andDo(print());

    }


    @Test
    @DisplayName("[GET] [findById] 호출")
    void findById() throws Exception {
        Long id = 22L;
        given(usersService.findById(id)).willReturn(new UsersDto().builder()
            .id(id)
            .username("hello")
            .password("121212")
            .phone_number("010010")
            .build());

        mockMvc.perform(
            get("/user/" + id))
            .andExpect(status().isOk())
            .andDo(print());
    }
}