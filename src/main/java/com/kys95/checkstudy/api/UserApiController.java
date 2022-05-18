package com.kys95.checkstudy.api;

import com.kys95.checkstudy.dto.UserJoinDto;
import com.kys95.checkstudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/joinProc")
    public int joinProc(@RequestBody UserJoinDto userJoinDto){
        userService.join(userJoinDto);
        return HttpStatus.OK.value();
    }
}
