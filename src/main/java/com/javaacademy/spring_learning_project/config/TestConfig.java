package com.javaacademy.spring_learning_project.config;

import com.javaacademy.spring_learning_project.entities.Category;
import com.javaacademy.spring_learning_project.entities.Order;
import com.javaacademy.spring_learning_project.entities.User;
import com.javaacademy.spring_learning_project.repositories.CategoryRepository;
import com.javaacademy.spring_learning_project.repositories.OrderRepository;
import com.javaacademy.spring_learning_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import entities.enums.OrderStatus;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    Category cat1 = new Category(null, "Electronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    @Override
    public  void run(String... argrs) throws  Exception{

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
        User u2 = new User(null, "Alex Brown", "alex@gmail.com", "1112888", "123456");

        Order o1 = new Order(null, Instant.parse("2026-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2026-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2026-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
