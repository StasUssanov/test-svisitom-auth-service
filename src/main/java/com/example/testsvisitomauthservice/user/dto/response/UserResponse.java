package com.example.testsvisitomauthservice.user.dto.response;

import com.example.testsvisitomauthservice.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private UUID uuid = null;
    private String username = null;
    private String password = null;

    public static UserResponse toResponse(UserEntity entity) {
        return new UserResponse(
                UUID.fromString(entity.getUuid()),
                entity.getUsername(),
                entity.getPassword()
        );
    }
}
