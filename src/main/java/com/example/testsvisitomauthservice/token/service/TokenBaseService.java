package com.example.testsvisitomauthservice.token.service;

import com.example.testsvisitomauthservice.session.repository.SessionRepository;
import com.example.testsvisitomauthservice.user.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class TokenBaseService {

    @Value("${app.jwt.secretString}")
    protected String secretString;

    @Value("${app.jwt.accessTokenLifeTimeMinutes}")
    protected Integer accessTokenLifeTimeMinutes;

    @Value("${app.jwt.refreshTokenLifeTimeMinutes}")
    protected Integer refreshTokenLifeTimeMinutes;

    @Autowired
    protected SessionRepository sessionRepository = null;

    @Autowired
    protected UserRepository userRepository = null;

}
