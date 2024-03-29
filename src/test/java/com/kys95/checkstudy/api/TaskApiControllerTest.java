//package com.kys95.checkstudy.api;
//
//import com.kys95.checkstudy.config.auth.PrincipalDetails;
//import com.kys95.checkstudy.dto.TaskWriteDto;
//import com.kys95.checkstudy.dto.UserJoinDto;
//import com.kys95.checkstudy.model.Task;
//import com.kys95.checkstudy.model.User;
//import com.kys95.checkstudy.repository.TaskRepository;
//import com.kys95.checkstudy.repository.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class TaskApiControllerTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TaskRepository taskRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    TestRestTemplate restTemplate;
//
//    @AfterEach
//    public void tearDown(){
//        taskRepository.deleteAll();
//        userRepository.deleteAll();
//    }
//
//    @Test
//    public void writeTest() throws Exception{
//        //given
//        String title ="Test Title";
//        String content = "<h1>Hello World</h1>";
//        User testUser = UserJoinDto.builder()
//                .username("kys95")
//                .password("1234")
//                .email("kys95@naver.com")
//                .nickname("yunseok")
//                .build().toEntity();
//
//        userRepository.save(testUser);
//        PrincipalDetails principalDetails = new PrincipalDetails(testUser);
//
//        LocalDateTime deadline = LocalDateTime.of(2022,6,4,0,0,0);
//        TaskWriteDto taskWriteDto = TaskWriteDto.builder()
//                .title(title)
//                .content(content)
//                .deadline(deadline)
//                .build();
//
//        String url = "http://localhost:"+port+"/api/writeProc";
//
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,taskWriteDto,Long.class);
//
//        //then
//        List<Task> list = taskRepository.findAll();
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);
//        Assertions.assertThat(list.get(0).getTitle()).isEqualTo(title);
//        Assertions.assertThat(list.get(0).getContent()).isEqualTo(content);
//        Assertions.assertThat(list.get(0).getDeadline()).isEqualTo(deadline);
//    }
//
//}
