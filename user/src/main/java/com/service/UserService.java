package com.service;

import com.domain.User;
import com.example.protobuf.UserProto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.repository.UserRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, UserProto.User> kafkaTemplate;

    public User getUserWithId(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found!"));
    }

    public void changeUserName(UUID userId, String username) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found!"));
        user.setName(username);
        userRepository.save(user);
        kafkaTemplate.send("user", userId.toString(), userToProto(user));
    }

    private UserProto.User userToProto(User user) {
        return UserProto.User.newBuilder()
                .setId(user.getId().toString())
                .setName(user.getName())
                .build();
    }
}
