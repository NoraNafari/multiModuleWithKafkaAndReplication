package com.service;

import com.domain.User;
import com.example.protobuf.UserProto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaListener {

    private final UserRepository userRepository;

    @org.springframework.kafka.annotation.KafkaListener(topics = "user", groupId = "testGroupId")
    public void listenToUserChangeEvents(UserProto.User user) {
        User savedUser = userRepository.findById(UUID.fromString(user.getId()))
                .orElse(null);
        if (savedUser!=null) {
            savedUser.setName(user.getName());
            userRepository.save(savedUser);
        }
    }
}
