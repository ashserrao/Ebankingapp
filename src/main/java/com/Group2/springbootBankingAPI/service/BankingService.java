package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.dto.KycdetailsDto;
import com.Group2.springbootBankingAPI.dto.MasteruserDto;
import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.exceptions.ResourceNotFoundException;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.KycRepo;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankingService {
    @Autowired
    private BankingRepo bankingRepo;

    @Autowired
    private KycRepo kycRepo;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
   private ModelMapper modelMapper;



    public KycdetailsDto SaveKyc(KycdetailsDto kycdetailsDto, Integer userId) {
        Masteruser user = bankingRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId));

        Kycdetails kycdetails = this.modelMapper.map(kycdetailsDto,Kycdetails.class);

        kycdetails.setCus_photo("default.jpg");
        kycdetails.setMasteruser(user);
        Kycdetails updatedKyc = this.kycRepo.save(kycdetails);
        return this.modelMapper.map(updatedKyc,KycdetailsDto.class);
    }


    public List<KycdetailsDto> getAllKycdetails() {
        List<Kycdetails> kycdetails = this.kycRepo.findAll();
        List<KycdetailsDto> kycdetailDtos= kycdetails.stream().map((kycdetail)->this.modelMapper.map
                (kycdetail,KycdetailsDto.class)).collect(Collectors.toList());
        return kycdetailDtos;

    }


}
