package com.service;

import com.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("No user found!"));
    }
}
