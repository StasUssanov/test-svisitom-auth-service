package com.example.testsvisitomauthservice.token.controller;

import com.example.testsvisitomauthservice.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public abstract class TokenBaseController {

    @Autowired
    protected TokenService tokenService;

}
