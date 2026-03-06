package com.javaacademy.spring_learning_project.services;

import com.javaacademy.spring_learning_project.entities.Product;
import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.ProductRepository;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();

    }
    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
