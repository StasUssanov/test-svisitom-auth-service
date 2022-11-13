package com.example.testsvisitomauthservice.user.entity;

import com.example.testsvisitomauthservice.user.dto.request.UserRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", length = 36, unique = true, updatable = false, nullable = false)
    private String uuid;

    @Column(name = "username", unique = true, nullable = false)
    String username = null;

    @Column(name = "password", nullable = false)
    String password = null;

    public static UserEntity toEntity(UserRequest request) {
        String uuid = null;
        if (request.getUuid() != null) uuid = request.getUuid().toString();
        return new UserEntity(
                uuid,
                request.getUsername(),
                request.getPassword()
        );
    }
}
