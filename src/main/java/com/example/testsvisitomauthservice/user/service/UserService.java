package com.example.testsvisitomauthservice.user.service;

import com.example.testsvisitomauthservice.user.dto.request.UserRequest;
import com.example.testsvisitomauthservice.user.dto.response.UserResponse;
import com.example.testsvisitomauthservice.user.entity.UserEntity;
import com.example.testsvisitomauthservice.user.exception.UserNameBusyException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserBaseService {

    public UserResponse createUser(UserRequest user) throws UserNameBusyException {
        if (userRepository.findAllByUsername(user.getUsername()).isPresent()) throw new UserNameBusyException();

        UserEntity entity = UserEntity.toEntity(user);
        return UserResponse.toResponse(userRepository.save(entity));
    }
}
