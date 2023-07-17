package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.dto.MasteruserDto;
import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.BeneficiaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BeneficiaryService
{
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
     private BankingRepo bankingRepo;

    public String  addBeneficiary(Beneficiary beneficiary,Integer userId){

        Masteruser user = bankingRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found"));

        //beneficiary.setMasteruser(user);
        Beneficiary beneficiary1 = beneficiaryRepository.save(beneficiary);
        return "Beneficiary Added Successfully";
    }

    public Beneficiary getBeneficiaryByuserId(Integer userId)
    {

        Masteruser user = bankingRepo.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found"));

       return beneficiaryRepository.findBeneficiaryByMasteruser(user);



    }

}
