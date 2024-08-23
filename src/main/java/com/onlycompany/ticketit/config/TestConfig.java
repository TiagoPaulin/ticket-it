package com.onlycompany.ticketit.config;

import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Tiago Paulin", "99999999", LocalDate.parse("12/08/2002", formatter), "tiago.paulin@gmail.com", "senha");
        User u2 = new User(null, "Gabriel Jess", "88888888", LocalDate.parse("12/08/2004", formatter), "gabriel.jess@gmail.com", "senha");
        User u3 = new User(null, "Brunno Tatsuo", "77777777", LocalDate.parse("12/08/1992", formatter), "brunno.tatsuo@gmail.com", "senha");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
