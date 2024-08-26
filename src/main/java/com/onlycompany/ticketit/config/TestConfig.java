package com.onlycompany.ticketit.config;

import com.onlycompany.ticketit.entities.Phone;
import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.repositories.PhoneRepository;
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
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Tiago Paulin", "99999999", "12/08/2002", "tiago.paulin@gmail.com", "senha");
        User u2 = new User(null, "Gabriel Jess", "88888888", "12/08/2004", "gabriel.jess@gmail.com", "senha");
        User u3 = new User(null, "Brunno Tatsuo", "77777777","12/08/1992", "brunno.tatsuo@gmail.com", "senha");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Phone p1 = new Phone(null, "+55", "41", "5551234", u1);
        Phone p2 = new Phone(null, "+55", "41", "5555678", u1);
        Phone p3 = new Phone(null, "+55", "41", "79460000", u2);
        Phone p4 = new Phone(null, "+55", "41", "45000000", u3);
        Phone p5 = new Phone(null, "+55", "41", "12345678", u3);

        phoneRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        u1.getPhones().add(p1);
        u1.getPhones().add(p2);
        u2.getPhones().add(p3);
        u3.getPhones().add(p4);
        u3.getPhones().add(p5);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
}
