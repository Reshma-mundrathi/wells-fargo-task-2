package com.wellsfargo.repositories;

import com.wellsfargo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Clientrepository extends JpaRepository<Client, Integer> {
    // Derived query to find clients by Financial Advisor ID
    List<Client> findByfinancialAdvisorId(Integer financialAdvisorId);

    // Find client by email
    Client findByEmail(String email);

    @Query("SELECT c FROM Client c WHERE c.financialAdvisor.id = :financialAdvisorId")
    List<Client> findClientsByFinancialAdvisorId(@Param("financialAdvisorId") Integer financialAdvisorId);

}
