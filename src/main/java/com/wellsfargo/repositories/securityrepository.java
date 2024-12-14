package com.wellsfargo.repositories;

import com.wellsfargo.entity.security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface securityrepository extends JpaRepository<Security, Integer> {
    // Derived query to find securities by category
    List<security> findByCategory(String category);

    // Derived query to find securities purchased after a specific date
    List<security> findByPurchaseDateAfter(LocalDate date);

    @Query("SELECT s FROM security s WHERE s.category = :category")
    List<Security> findSecuritiesByCategory(@Param("category") String category);

}

