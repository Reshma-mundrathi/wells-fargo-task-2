package com.wells-fargo-task-2.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer totalValue;

    @ManyToOne
    @JoinColumn(name = "C_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    // Constructors
    public Portfolio() {}

    public Portfolio(Integer totalValue, Client client) {
        this.totalValue = totalValue;
        this.client = client;
    }

    // Getters and Setters
}
