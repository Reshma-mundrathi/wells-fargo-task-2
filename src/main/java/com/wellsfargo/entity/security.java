package com.wells-fargo-task-2.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "P_id", nullable = false)
    private Portfolio portfolio;

    // Constructors
    public Security() {}

    public Security(String name, String category, LocalDate purchaseDate, Integer price, String quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    // Getters and Setters
}
