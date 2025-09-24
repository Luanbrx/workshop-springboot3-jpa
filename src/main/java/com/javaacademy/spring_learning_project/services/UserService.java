package com.javaacademy.spring_learning_project.services;

import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();

    }
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
