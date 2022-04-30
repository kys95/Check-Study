package com.kys95.checkstudy.dto;


import com.kys95.checkstudy.model.Role;
import com.kys95.checkstudy.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinDto {

    private String username;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    @Builder
    public UserJoinDto(String username, String password, String email, String nickname){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(role)
                .build();
    }
}
