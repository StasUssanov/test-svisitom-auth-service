package com.example.testsvisitomauthservice.user.controller;

import com.example.testsvisitomauthservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public abstract class UserBaseController {

    @Autowired
    protected UserService userService;

}
