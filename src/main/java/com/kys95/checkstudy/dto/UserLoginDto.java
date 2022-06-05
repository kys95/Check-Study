package com.kys95.checkstudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDto {
    private String username;
    private String password;

    @Builder
    UserLoginDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
