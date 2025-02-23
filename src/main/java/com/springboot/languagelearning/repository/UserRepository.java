package com.springboot.languagelearning.repository;

import com.springboot.languagelearning.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @SuppressWarnings("null")
    Page<User> findAll(Pageable pageable);

}
