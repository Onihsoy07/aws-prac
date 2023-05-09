package com.example.awsprac.controller.api;

import com.example.awsprac.domain.dto.ResponseDto;
import com.example.awsprac.domain.dto.UsersDto;
import com.example.awsprac.domain.dto.UsersJoinDto;
import com.example.awsprac.domain.dto.UsersUpdateDto;
import com.example.awsprac.service.UsersService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersApiController {

    private final UsersService usersService;

    private final Logger LOGGER = LoggerFactory.getLogger(UsersApiController.class);

    @GetMapping("/user")
    public ResponseDto<List<UsersDto>> findAll() {
        LOGGER.info("[GET] [/user] 호출");
        return new ResponseDto<>(HttpStatus.OK.value(), usersService.fildAll());
    }

    @GetMapping("/user/{id}")
    public ResponseDto<UsersDto> findById(@PathVariable final Long id) {
        LOGGER.info("[GET] [/user/{}] 호출", id);
        return new ResponseDto<>(HttpStatus.OK.value(), usersService.findById(id));
    }

    @PostMapping("/user")
    public ResponseDto<?> save(@RequestBody @Valid final UsersJoinDto usersJoinDto, BindingResult bindingResult) {
        
        LOGGER.info("[POST] [/user] 호출");

        UsersDto usersDto = usersService.sava(usersJoinDto);
        return new ResponseDto<>(HttpStatus.OK.value(), usersDto);
    }
//
//    @DeleteMapping("/user/{id}")
//    public void delete(@PathVariable final Long id) {
//
//
//    }
//
    @PutMapping("/user/{id}")
    public ResponseDto<?> update(@PathVariable final Long id,
                       @RequestBody @Valid final UsersUpdateDto usersUpdateDto,
                       BindingResult bindingResult) {
        LOGGER.info("[POST] [/user/{}] 호출", id);

        UsersDto usersDto = usersService.update(id, usersUpdateDto);
        return new ResponseDto<>(HttpStatus.OK.value(), usersDto);
    }

    @GetMapping({"/",""})
    public String index() {
        System.out.println("hello");
        return "<h1>hello</h1>";
    }

}
