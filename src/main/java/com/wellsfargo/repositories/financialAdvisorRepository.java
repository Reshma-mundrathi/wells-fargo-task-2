package com.wellsfargo.repositories;

import com.wellsfargo.entity.financialAdvisor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface financialAdvisorRepository extends JpaRepository<financialAdvisor, Integer> {

    // Native SQL query to find FinancialAdvisor by email
    @Query(value = "SELECT * FROM financialAdvisor WHERE email = :email", nativeQuery = true)
    financialAdvisor findByEmailNative(@Param("email") String email);

    // Native SQL query to find FinancialAdvisors whose name matches a keyword (case-insensitive)
    @Query(value = "SELECT * FROM financialAdvisor WHERE LOWER(name) LIKE LOWER(CONCAT('%', :keyword, '%'))", nativeQuery = true)
    List<financialAdvisor> searchByNameKeywordNative(@Param("keyword") String keyword);

    // Native SQL query to find FinancialAdvisors with working hours not null
    @Query(value = "SELECT * FROM financialAdvisor WHERE working_hours IS NOT NULL", nativeQuery = true)
    List<financialAdvisor> findWithWorkingHoursNative();

    // Native SQL query to get all FinancialAdvisors with mobile numbers greater than a value
    @Query(value = "SELECT * FROM financialAdvisor WHERE mobile_number > :mobileNumber", nativeQuery = true)
    List<financialAdvisor> findByMobileNumberGreaterThanNative(@Param("mobileNumber") Integer mobileNumber);
}

