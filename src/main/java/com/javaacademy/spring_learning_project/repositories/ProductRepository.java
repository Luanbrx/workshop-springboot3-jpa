package com.javaacademy.spring_learning_project.repositories;

import com.javaacademy.spring_learning_project.entities.Category;
import com.javaacademy.spring_learning_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

