package com.project.pts;

import com.project.pts.services.IUserService;
import com.project.pts.services.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class PtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtsApplication.class, args);
    }

}
