package com.Group2.springbootBankingAPI.repository;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycRepo extends JpaRepository<Kycdetails,Integer> {
}
