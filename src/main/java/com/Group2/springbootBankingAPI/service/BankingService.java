package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.KycRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingService {
    @Autowired
    BankingRepo bankingRepo;
    KycRepo kycRepo;

            public String SaveUser(Masteruser masteruser){
                bankingRepo.save(masteruser);
                return "User Saved Successfully";
            }

            public String SaveKyc(Kycdetails kycdetails){
                kycRepo.save(kycdetails);
                return "Kyc Saved Successfully";
            }


}
