package com.springboot.languagelearning.controller;

import com.springboot.languagelearning.entities.Language;
import com.springboot.languagelearning.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
//import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/add")
    public Language createLanguage(@RequestBody Language language) {
        return languageService.createLanguage(language);
    }

    @GetMapping("/getAll")
    public Page<Language> getAllLanguages(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Pageable pageable = PageRequest.of(page, size, 
                        sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() 
                                                                : Sort.by(sortBy).descending());
        return languageService.getAllLanguages(pageable);
    }


    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable Long id) {
        return languageService.getLanguageById(id).orElse(null);
    }

    @GetMapping("/code/{code}")
    public Language getLanguageByCode(@PathVariable String code) {
        return languageService.getLanguageByCode(code).orElse(null);
    }

    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable Long id, @RequestBody Language languageDetails) {
        return languageService.updateLanguage(id, languageDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return "Language deleted successfully.";
    }
}
