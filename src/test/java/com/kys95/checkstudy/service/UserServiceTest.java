//package com.kys95.checkstudy.service;
//
//import com.kys95.checkstudy.dto.UserJoinDto;
//
//
//import com.kys95.checkstudy.dto.UserUpdateDto;
//import com.kys95.checkstudy.model.User;
//import com.kys95.checkstudy.repository.UserRepository;
//
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.transaction.annotation.Transactional;
//
//import static com.kys95.checkstudy.model.Role.USER;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//
//@SpringBootTest
//public class UserServiceTest {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @AfterEach
//    public void cleanup(){
//        userRepository.deleteAll();
//    }
//
//    @Test
//    @DisplayName("db에 회원이 없을 때 join기능이 제대로 동작하는지 확인")
//    void joinTrue(){
//        //given
//        UserJoinDto userJoinDto = UserJoinDto.builder()
//                .username("kys95")
//                .password("1111")
//                .email("mok02198@naver.com")
//                .nickname("yunseok")
//                .build();
//        String rawPassword = userJoinDto.getPassword();
//
//        //when
//        Boolean isJoined = userService.join(userJoinDto);
//
//        //then
//        assertThat(isJoined).isEqualTo(true);
//
//    }
//
//    @Test
//    @DisplayName("db에 회원이 있을 때 join기능이 제대로 동작하는지 확인")
//    void joinFalse(){
//        //given
//        String username = "kys95";
//        String nickname = "yunseok";
//        String email = "mok02198@naver.com";
//        String password = "1234";
//
//        User user = User.builder()
//                .username(username)
//                .nickname(nickname)
//                .email(email)
//                .password(password)
//                .role(USER)
//                .build();
//
//        User findUser = userRepository.save(user);
//        System.out.println("findUser = " + findUser);
//
//        UserJoinDto userJoinDto = UserJoinDto.builder()
//                .username("kys95")
//                .password("1111")
//                .email("mok02198@naver.com")
//                .nickname("yunseok")
//                .build();
//
//        //when
//        Boolean isJoined = userService.join(userJoinDto);
//
//        //then
//        assertThat(isJoined).isEqualTo(false);
//    }
//
//    @Test
//    @DisplayName("update 실패 확인")
//    void updateFalse(){
//        //given
//        Long userId = 0L;
//        UserUpdateDto userUpdateDto = UserUpdateDto.builder()
//                .password("1111")
//                .email("mok02198@naver.com")
//                .nickname("yunseok")
//                .build();
//
//        //then
//        assertThatThrownBy(() -> userService.update(userId, userUpdateDto))
//                .isInstanceOf(IllegalArgumentException.class);
//
//    }

//    @Test
//    @DisplayName("update 성공 확인")
//    void updateTrue(){
//        //given
//        UserJoinDto userJoinDto = UserJoinDto.builder()
//                .username("kys95")
//                .password("1111")
//                .email("mok02198@naver.com")
//                .nickname("yunseok")
//                .build();
//
//        Boolean isJoined = userService.join(userJoinDto);
//        User findUser = userRepository.findByUsername(userJoinDto.getUsername()).get();
//        Long userId = findUser.getId();
//
//        UserUpdateDto userUpdateDto = UserUpdateDto.builder()
//                .password("1111")
//                .email("mok02198@gmail.com")
//                .nickname("yunseok")
//                .build();
//
//        //when
//        userService.update(userId, userUpdateDto);
//
//        //then
//        User testUser = userRepository.getById(userId);
//
//
//        assertThat(testUser.getEmail()).isEqualTo(userUpdateDto.getEmail());
//
//    }

//}


