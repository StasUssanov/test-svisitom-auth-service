package com.example.testsvisitomauthservice.user.service;

import com.example.testsvisitomauthservice.user.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class UserBaseService {
    @Autowired
    protected UserRepository userRepository = null;

}
