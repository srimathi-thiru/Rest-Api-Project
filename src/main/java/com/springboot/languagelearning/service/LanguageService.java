package com.springboot.languagelearning.service;

import com.springboot.languagelearning.entities.Language;
import com.springboot.languagelearning.repository.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Page<Language> getAllLanguages(Pageable pageable) {
        return languageRepository.findAll(pageable);
    }

    public Optional<Language> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    public Optional<Language> getLanguageByCode(String code) {
        return languageRepository.findByCode(code);
    }

    public Language updateLanguage(Long id, Language languageDetails) {
        Optional<Language> languageOpt = languageRepository.findById(id);
        if (languageOpt.isPresent()) {
            Language language = languageOpt.get();
            language.setName(languageDetails.getName());
            language.setCode(languageDetails.getCode());
            language.setDescription(languageDetails.getDescription());
            return languageRepository.save(language);
        }
        return null;
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
