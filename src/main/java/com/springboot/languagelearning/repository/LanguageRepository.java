package com.springboot.languagelearning.repository;

import com.springboot.languagelearning.entities.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Optional<Language> findByCode(String code);

    @SuppressWarnings("null")
    Page<Language> findAll(Pageable pageable);
}
