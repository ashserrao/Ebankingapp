package com.Group2.springbootBankingAPI.repository;

import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.Transactions;

import com.Group2.springbootBankingAPI.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transactions, Long>
{
  //    List<Transactions> findByMasteruser_MasteruserId(Long masteruserId);

}
