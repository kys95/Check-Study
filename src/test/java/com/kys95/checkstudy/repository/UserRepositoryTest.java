package com.kys95.checkstudy.repository;



import com.kys95.checkstudy.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static com.kys95.checkstudy.model.Role.USER;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void joinTest(){
        //given
        String username = "kys95";
        String nickname = "yunseok";
        String email = "mok02198@naver.com";
        String password = "1234";

        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .email(email)
                .password(password)
                .role(USER)
                .build();

        //when
        User testUser = userRepository.save(user);

        //then
        assertEquals(username, testUser.getUsername());
        assertEquals(nickname, testUser.getNickname());
        assertEquals(email, testUser.getEmail());
        assertEquals(password, testUser.getPassword());
        assertEquals(USER, testUser.getRole());


    }

    @Test
    public void findByUsernameTest(){
        //given
        String username = "kys95";
        String nickname = "yunseok";
        String email = "mok02198@naver.com";
        String password = "1234";

        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .email(email)
                .password(password)
                .role(USER)
                .build();

        //when
        User testUser = userRepository.save(user);
        User findUser = userRepository.findByUsername(user.getUsername()).get();

        assertEquals(email, findUser.getEmail());

    }


}
