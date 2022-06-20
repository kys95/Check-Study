package com.kys95.checkstudy.repository;

import com.kys95.checkstudy.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task> findAllByUserIdAndIsSuccess(Long userId, int isSuccess, Pageable pageable);
}
