package com.javaacademy.spring_learning_project.repositories;

import com.javaacademy.spring_learning_project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
