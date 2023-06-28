package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @PostMapping("/working")
    public String BankingSave(@RequestBody Masteruser masteruser){
        return bankingService.SaveUser(masteruser);
    }

    @PostMapping("/kyc")
    public String SaveKyc(@RequestBody Kycdetails kycdetails){
        return bankingService.SaveKyc(kycdetails);
    }
}
