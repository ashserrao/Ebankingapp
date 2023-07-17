package com.Group2.springbootBankingAPI.repository;

import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.Masteruser;
//import com.Group2.springbootBankingAPI.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Integer>
{
   Beneficiary findBeneficiaryByMasteruser(Masteruser user);

}
