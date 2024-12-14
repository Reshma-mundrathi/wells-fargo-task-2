package com.wells-fargo-task-2.entities;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class financialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;


    @Column(unique = true, nullable = false)
    private String email;


    @column
    private Integer working_hours;

    @OneToMany(mappedBy = "financialAdvisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // Constructors, Getters, and Setters
    public FinancialAdvisor() {}

    public FinancialAdvisor(String name, String email, Integer mobileNumber, String workingHours) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.workingHours = workingHours;
}

