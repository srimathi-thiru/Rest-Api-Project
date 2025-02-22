package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.Language;
import com.springboot.languagelearning.service.LanguageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/createLanguage")
    public Language createLanguage(@RequestBody Language language) {
        return languageService.createLanguage(language);
    }

    @GetMapping("/getLanguages")
    public ResponseEntity<Page<Language>> getAllLanguages(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Pageable pageable = PageRequest.of(page, size,
                          sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        Page<Language> languages = languageService.getAllLanguages(pageable);
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Language>> getLanguageById(@PathVariable Long id) {
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<Optional<Language>> getLanguageByCode(@PathVariable String code) {
        return ResponseEntity.ok(languageService.getLanguageByCode(code));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language languageDetails) {
        Language updatedLanguage = languageService.updateLanguage(id, languageDetails);
        return updatedLanguage != null ? ResponseEntity.ok(updatedLanguage) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.ok("Language deleted successfully.");
    }
}
