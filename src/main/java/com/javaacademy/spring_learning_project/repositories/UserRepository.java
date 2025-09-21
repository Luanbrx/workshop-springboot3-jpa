package com.javaacademy.spring_learning_project.repositories;

import com.javaacademy.spring_learning_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

