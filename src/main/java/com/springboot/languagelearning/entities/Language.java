package com.springboot.languagelearning.entities;

import jakarta.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languagename;
    private String code;  
    private String description;

    
    public Language() {
    }

    
    public Language(String languagename, String code, String description) {
        this.languagename = languagename;
        this.code = code;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return languagename;
    }

    public void setName(String languagename) {
        this.languagename = languagename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
