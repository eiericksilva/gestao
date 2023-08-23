package com.eiericksilvagroup.gestao.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eiericksilvagroup.gestao.entities.User;
import com.eiericksilvagroup.gestao.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User(null, "Maria Aparecida", "maria@gmail.com", "988888888", "123456");
        User usuario2 = new User(null, "Evelyn Fernanda", "evelyn@gmail.com", "988888888", "123456");

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));
    }
}
