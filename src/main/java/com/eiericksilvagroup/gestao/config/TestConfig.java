package com.eiericksilvagroup.gestao.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eiericksilvagroup.gestao.entities.Category;
import com.eiericksilvagroup.gestao.entities.Order;
import com.eiericksilvagroup.gestao.entities.OrderItem;
import com.eiericksilvagroup.gestao.entities.Payment;
import com.eiericksilvagroup.gestao.entities.Product;
import com.eiericksilvagroup.gestao.entities.User;
import com.eiericksilvagroup.gestao.entities.enums.OrderStatus;
import com.eiericksilvagroup.gestao.repositories.CategoryRepository;
import com.eiericksilvagroup.gestao.repositories.OrderItemRepository;
import com.eiericksilvagroup.gestao.repositories.OrderRepository;
import com.eiericksilvagroup.gestao.repositories.ProductRepository;
import com.eiericksilvagroup.gestao.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Maria Aparecida", "maria@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Evelyn Fernanda", "evelyn@gmail.com", "988888888", "123456");

        Order order1 = new Order(null, Instant.parse("2023-08-23T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2023-07-23T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2023-06-23T19:53:07Z"), OrderStatus.WAITING_PAYMENT, user2);

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,
                "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,
                "");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(cat2);
        product2.getCategories().add(cat1);
        product2.getCategories().add(cat3);
        product3.getCategories().add(cat3);
        product4.getCategories().add(cat3);
        product5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        Payment payment1 = new Payment(null, Instant.parse("2023-06-23T22:53:07Z"), order1);

        order1.setPayment(payment1);

        orderRepository.save(order1);
    }

}
