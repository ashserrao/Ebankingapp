package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.dto.MasteruserDto;
import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.exceptions.ResourceNotFoundException;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.BeneficiaryRepository;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
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

    @Autowired
    private UserLoginRepository userLoginRepository;

    public Beneficiary  addBeneficiary(Beneficiary beneficiary,Integer userId){

        Masteruser user = bankingRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId));


        Beneficiary beneficiary1 = beneficiaryRepository.save(beneficiary);
        return beneficiary1;
    }

    public Beneficiary updateBeneficiaryById(Beneficiary beneficiary,Integer beneficiaryId)
    {
        Beneficiary beneficiary1= beneficiaryRepository.findById(beneficiaryId).orElseThrow(
                ()->new ResourceNotFoundException("Beneficiary","id",beneficiaryId));
        UserLogin userLogin = new UserLogin();
        beneficiary1.setBeneficiary_accno(beneficiary.getBeneficiary_accno());
        beneficiary1.setBeneficiary_name(beneficiary.getBeneficiary_name());
        beneficiary1.setBank_name(beneficiary.getBank_name());
        beneficiary1.setMax_limit(beneficiary.getMax_limit());
        Beneficiary beneficiary2 =  beneficiaryRepository.save(beneficiary1);
        userLogin.setBeneficiary(beneficiary2);
       // userLoginRepository.save(userLogin);
        return beneficiary2;




    }

}
