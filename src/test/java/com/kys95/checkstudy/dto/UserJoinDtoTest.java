package com.kys95.checkstudy.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserJoinDtoTest {

    @Test
    public void dtoBuilderTest(){
        UserJoinDto userJoinDto = UserJoinDto.builder()
                .username("kys95")
                .password("1111")
                .email("mok02198@naver.com")
                .nickname("yunseok")
                .build();
        assertThat(userJoinDto.getUsername()).isEqualTo("kys95");
        assertThat(userJoinDto.getPassword()).isEqualTo("1111");
        assertThat(userJoinDto.getEmail()).isEqualTo("mok02198@naver.com");
        assertThat(userJoinDto.getNickname()).isEqualTo("yunseok");
    }
}
