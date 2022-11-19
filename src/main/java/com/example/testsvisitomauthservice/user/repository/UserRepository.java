package com.example.testsvisitomauthservice.user.repository;

import com.example.testsvisitomauthservice.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findAllByUsername(String username);
}
