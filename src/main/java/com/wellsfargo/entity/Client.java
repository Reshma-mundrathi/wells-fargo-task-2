package com.wells-fargo-task-2.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer mobileNumber;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "F_id", nullable = false)
    private FinancialAdvisor financialAdvisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    // Constructors
    public Client() {}

    public Client(String name, String email, Integer mobileNumber, String address, FinancialAdvisor financialAdvisor) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.financialAdvisor = financialAdvisor;
    }

    // Getters and Setters
}

