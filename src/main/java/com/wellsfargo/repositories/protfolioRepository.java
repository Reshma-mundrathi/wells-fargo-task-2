package com.wellsfargo.repositories;

import com.wellsfargo.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface portfolioRepository extends JpaRepository<Portfolio, Integer> {
    // Derived query to find portfolios by client ID
    List<Portfolio> findByClientId(Integer clientId);

    // Derived query to find portfolios with a total value greater than a specified amount
    List<Portfolio> findByTotalValueGreaterThan(Integer value);

    @Query("SELECT p FROM Portfolio p WHERE p.client.id = :clientId")
    List<Portfolio> findPortfoliosByClientId(@Param("clientId") Integer clientId);

}
