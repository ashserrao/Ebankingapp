package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Mainuser;
import com.Group2.springbootBankingAPI.entity.MasterUser;
import com.Group2.springbootBankingAPI.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @PostMapping("/createUser")
    public String BankingSave(@RequestBody MasterUser masterUser){
        return bankingService.SaveUser(masterUser);
    }

//    @PostMapping("/{userId}/createKyc")
//    public ResponseEntity<Kycdetails> createKyc(@RequestBody Kycdetails kycdetails, @PathVariable Integer userId)
//    {
//        Kycdetails createdKyc =  this.bankingService.SaveKyc(kycdetails,userId);
//        return new ResponseEntity<Kycdetails>(createdKyc, HttpStatus.CREATED);
//    }
}

