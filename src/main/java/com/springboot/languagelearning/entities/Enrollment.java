package com.springboot.languagelearning.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;  

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;  

    private double progressPercentage;

    private LocalDate enrollmentDate;

    
    public Enrollment() {
    }

    public Enrollment(User user, Course course, double progressPercentage, LocalDate enrollmentDate) {
        this.user = user;
        this.course = course;
        this.progressPercentage = progressPercentage;
        this.enrollmentDate = enrollmentDate;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
