package com.example.demo.user.service;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원 가입 기능
    public UserEntity createServ(final UserEntity userEntity) throws RuntimeException {
        if (userEntity == null || userEntity.getEmail() == null) {
            throw new RuntimeException("Invalid args!");
        }

        boolean flag = userRepository.register(userEntity);

        return flag
                ? getByCredential(userEntity)
                : null;
    }

    public UserEntity getByCredential(UserEntity userEntity) {
        return userRepository.findUserByEmail(userEntity.getEmail());
    }
}








