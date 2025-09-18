package com.javaacademy.spring_learning_project.resources;

import com.javaacademy.spring_learning_project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/users")
public class UserResource {

       @GetMapping
      public ResponseEntity<User> findAll(){
          User u = new User(1L,"luan","@gmail.com","00000","1111");
          return ResponseEntity.ok().body(u);
      }
}
