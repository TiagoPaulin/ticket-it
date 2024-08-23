package com.onlycompany.ticketit.services;

import com.onlycompany.ticketit.entities.User;
import com.onlycompany.ticketit.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findById (Long id) {

        Optional<User> obj = repository.findById(id);

        return obj.get();

    }

    public User insert (User obj) {

        return repository.save(obj);

    }

    public void delete (Long id) {

        repository.deleteById(id);

    }

    @Transactional
    public User update (Long id, User obj) {

        User user = repository.getReferenceById(id);

        updateData(user, obj);

        return repository.save(user);

    }

    private void updateData(User user, User obj) {

        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPassword(obj.getPassword());

    }

}
