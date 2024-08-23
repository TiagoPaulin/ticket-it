package com.onlycompany.ticketit.repositories;

import com.onlycompany.ticketit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
