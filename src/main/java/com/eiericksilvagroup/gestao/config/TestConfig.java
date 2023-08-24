package com.eiericksilvagroup.gestao.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eiericksilvagroup.gestao.entities.Order;
import com.eiericksilvagroup.gestao.entities.User;
import com.eiericksilvagroup.gestao.entities.enums.OrderStatus;
import com.eiericksilvagroup.gestao.repositories.OrderRepository;
import com.eiericksilvagroup.gestao.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User(null, "Maria Aparecida", "maria@gmail.com", "988888888", "123456");
        User usuario2 = new User(null, "Evelyn Fernanda", "evelyn@gmail.com", "988888888", "123456");

        Order order1 = new Order(null, Instant.parse("2023-08-23T19:53:07Z"), OrderStatus.PAID, usuario1);
        Order order2 = new Order(null, Instant.parse("2023-07-23T19:53:07Z"), OrderStatus.WAITING_PAYMENT, usuario2);
        Order order3 = new Order(null, Instant.parse("2023-06-23T19:53:07Z"), OrderStatus.WAITING_PAYMENT, usuario1);

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }

}
