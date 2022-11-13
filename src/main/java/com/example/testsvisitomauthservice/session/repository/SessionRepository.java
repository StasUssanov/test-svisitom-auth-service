package com.example.testsvisitomauthservice.session.repository;

import com.example.testsvisitomauthservice.session.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, String> {
}
