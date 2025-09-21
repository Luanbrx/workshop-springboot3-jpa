package com.javaacademy.spring_learning_project.config;

import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public  void run(String... argrs) throws  Exception{

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Alex Brown", "alex@gmail.com", "1112888", "123456");

           userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
