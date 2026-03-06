package com.javaacademy.spring_learning_project.services;

import com.javaacademy.spring_learning_project.entities.Category;
import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.CategoryRepository;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();

    }
    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
