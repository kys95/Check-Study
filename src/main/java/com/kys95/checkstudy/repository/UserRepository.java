package com.kys95.checkstudy.repository;

import com.kys95.checkstudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
