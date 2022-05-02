package com.kys95.checkstudy.repository;

import com.kys95.checkstudy.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
