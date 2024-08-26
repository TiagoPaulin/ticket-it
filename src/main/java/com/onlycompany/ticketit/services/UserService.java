package com.onlycompany.ticketit.services;

import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.repositories.UserRepository;
import com.onlycompany.ticketit.services.exceptions.BadRequestException;
import com.onlycompany.ticketit.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findById (Long id) {

        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public User insert (User obj) {

        validateUser(obj);

        return repository.save(obj);

    }

    public void delete (Long id) {

        if (!repository.existsById(id)) {

            throw new ResourceNotFoundException(id);

        }

        repository.deleteById(id);

    }

    @Transactional
    public User update (Long id, User obj) {

        if (!repository.existsById(id)) {

            throw new ResourceNotFoundException(id);

        }

        User user = repository.getReferenceById(id);

        updateData(user, obj);

        return repository.save(user);

    }

    private void updateData(User user, User obj) {

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPassword(obj.getPassword());

    }

    private void validateUser(User user) {

        if (isNullOrEmptyOrBlank(user.getName()) || !(user.getName().length() >= 2)) {

            throw new BadRequestException("Name is required and must be at least 2 characters long.");

        }

        if (isNullOrEmptyOrBlank(user.getCpf())) {

            throw new BadRequestException("CPF is required.");

        }

        if (user.getBirthDate() == null || user.getBirthDate().isAfter(LocalDate.now())) {

            throw new BadRequestException("Birthdate is required and must be in the past.");

        }

        if (isNullOrEmptyOrBlank(user.getEmail()) || !user.getEmail().contains("@")) {

            throw new BadRequestException("Email is required and must be valid.");

        }

        if (isNullOrEmptyOrBlank(user.getPassword()) || user.getPassword().length() < 6) {

            throw new BadRequestException("Password is required and must be at least 6 characters long.");

        }

    }

    private boolean isNullOrEmptyOrBlank(String value) {

        return value == null || value.trim().isEmpty();

    }

}
