package com.example.testsvisitomauthservice.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private UUID uuid = null;
    private String username = null;
    private String password = null;
}
