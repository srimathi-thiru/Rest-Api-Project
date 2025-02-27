package com.springboot.languagelearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.languagelearning.entities.Registration;
import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    
    // Custom JPA Methods
    List<Registration> findByUser(String user); 

    List<Registration> findByCourse(String course); 

    long countByCourse(String course); 
}
