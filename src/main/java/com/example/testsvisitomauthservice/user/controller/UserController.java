package com.example.testsvisitomauthservice.user.controller;

import com.example.testsvisitomauthservice.user.dto.request.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "Управление пользователями")
public class UserController extends UserBaseController {

    @PostMapping
    @Operation(description = "Создать пользователя")
    public ResponseEntity<?> createUser(@RequestBody UserRequest user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

}
