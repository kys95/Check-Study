package com.kys95.checkstudy.service;

import com.kys95.checkstudy.dto.TaskWriteDto;
import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public void write(TaskWriteDto taskWriteDto){
        taskRepository.save(taskWriteDto.toEntity());
    }

    @Transactional(readOnly = true)
    public List<Task> findList() {
        return taskRepository.findAll();
    }

}
