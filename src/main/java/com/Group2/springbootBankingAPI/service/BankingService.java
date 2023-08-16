package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Mainuser;
import com.Group2.springbootBankingAPI.entity.MasterUser;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.KycRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingService {
    @Autowired
    private BankingRepo bankingRepo;

    @Autowired
    private KycRepo kycRepo;

    public String SaveUser(MasterUser masterUser) {
        bankingRepo.save(masterUser);
        return "User Saved Successfully";
    }

//    public Kycdetails SaveKyc(Kycdetails kycdetails, Integer userId) {
//        Mainuser masterUser = bankingRepo.findById(userId).orElseThrow(
//                () -> new RuntimeException("User not found"));
//
//        kycdetails.setCus_photo("default.jpg");
//        kycdetails.setMasteruser(masterUser);
//        Kycdetails updatedKyc = kycRepo.save(kycdetails);
//        return updatedKyc;
//    }

}
