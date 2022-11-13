package com.example.testsvisitomauthservice;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestSvisitomAuthServiceApplication {

    @Autowired
    private BuildProperties buildProperties;

    public static void main(String[] args) {
        SpringApplication.run(TestSvisitomAuthServiceApplication.class, args);
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()).info(
                new Info()
                        .title("Auth Service")
                        .version(buildProperties.getVersion())
        );
    }
}
