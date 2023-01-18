package com.controller;

import com.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.UserService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserWithId(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(userService.getUserWithId(userId));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Void> updateUsername(@PathVariable UUID userId, @RequestBody String username) {
        userService.changeUserName(userId, username);
        return ResponseEntity.ok().build();
    }
}
