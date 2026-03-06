package com.javaacademy.spring_learning_project.services;

import com.javaacademy.spring_learning_project.entities.Order;
import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.OrderRepository;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();

    }
    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
