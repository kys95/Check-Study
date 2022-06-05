package com.kys95.checkstudy.service;

import com.kys95.checkstudy.dto.UserJoinDto;
import com.kys95.checkstudy.model.Role;
import com.kys95.checkstudy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void join(UserJoinDto userJoinDto){
        String rawPassword = userJoinDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userJoinDto.setPassword(encPassword);
        userJoinDto.setRole(Role.USER);
        userRepository.save(userJoinDto.toEntity());
    }

}
