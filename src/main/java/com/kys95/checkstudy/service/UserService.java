package com.kys95.checkstudy.service;

import com.kys95.checkstudy.dto.UserJoinDto;
import com.kys95.checkstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void join(UserJoinDto userJoinDto){

        userRepository.save(userJoinDto.toEntity());
    }

}
