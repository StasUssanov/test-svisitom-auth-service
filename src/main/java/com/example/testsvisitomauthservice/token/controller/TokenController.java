package com.example.testsvisitomauthservice.token.controller;

import com.example.testsvisitomauthservice.user.dto.request.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Управление токенами")
public class TokenController extends TokenBaseController {

    @PostMapping
    @Operation(description = "Получить токены")
    public ResponseEntity<?> getTokens(@RequestBody UserRequest user) {
        try {
            return ResponseEntity.ok(tokenService.createTokens(user));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PutMapping
    @Operation(description = "Обновить токены")
    public ResponseEntity<?> refreshTokens(@RequestHeader String authorization) {
        try {
            String token = authorization.replace("Bearer", "");
            return ResponseEntity.ok(tokenService.refreshTokens(token));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @DeleteMapping
    @Operation(description = "Удалить токены")
    public ResponseEntity<String> killTokens(@RequestHeader String authorization) {
        try {
            String token = authorization.replace("Bearer", "");
            return ResponseEntity.ok(tokenService.killTokens(token));
        } catch (Exception error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
