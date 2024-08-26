package com.onlycompany.ticketit.repositories;

import com.onlycompany.ticketit.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
}
