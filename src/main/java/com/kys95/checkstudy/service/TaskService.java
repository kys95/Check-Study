package com.kys95.checkstudy.service;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import com.kys95.checkstudy.dto.TaskWriteDto;
import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.model.User;
import com.kys95.checkstudy.repository.TaskRepository;
import com.kys95.checkstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Transactional
    public void write(TaskWriteDto taskWriteDto, PrincipalDetails principalDetails){
        User findUser = userRepository.findByUsername(principalDetails.getUsername()).orElseThrow(()->{
            return new IllegalArgumentException("해당 유저를 찾을 수 없습니다.");
        });
        taskWriteDto.setUser(findUser);
        taskRepository.save(taskWriteDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<Task> findList(PrincipalDetails principalDetails) {
        return taskRepository.findAllByUserId(principalDetails.getUserId());
    }

}
