package com.javaacademy.spring_learning_project.repositories;

import com.javaacademy.spring_learning_project.entities.OrderItem;
import com.javaacademy.spring_learning_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

