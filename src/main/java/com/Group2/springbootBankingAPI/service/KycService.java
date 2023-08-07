package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.exceptions.ResourceNotFoundException;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.KycRepo;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class KycService
{
    @Autowired
   private KycRepo kycRepo;

    @Autowired
    private BankingRepo bankingRepo;

    @Autowired
    private UserLoginRepository userLoginRepository;


    public Kycdetails getKycdetailsById(int kycId){

        return kycRepo.findById(kycId).orElseThrow(
                ()->new ResourceNotFoundException("Kycdetails","id",kycId));
    }

    public Kycdetails updateKycdetailsimageById(Kycdetails kycdetails,int kycId){

       Kycdetails kycdetails1 =  kycRepo.findById(kycId).orElseThrow(
               ()->new ResourceNotFoundException("Kycdetails","id",kycId));
        kycdetails1.setCus_photo(kycdetails.getCus_photo());
        Kycdetails updatedkycdetails = this.kycRepo.save(kycdetails1);
        return updatedkycdetails;
    }

    public Kycdetails updateKycdetailsById(Kycdetails kycdetails, Integer kycId)
    {
        Kycdetails kycdetails1= kycRepo.findById(kycId).orElseThrow(
                ()->new ResourceNotFoundException("Kycdetails","id",kycId));
        UserLogin userLogin = new UserLogin();
        Masteruser masteruser = new Masteruser();
        kycdetails1.setPan_no(kycdetails.getPan_no());
        kycdetails1.setAadhar_no(kycdetails.getAadhar_no());
        Kycdetails kycdetails2 =  kycRepo.save(kycdetails1);
        masteruser.setKycdetails(kycdetails2);
       // Masteruser masteruser1 = bankingRepo.save(masteruser);
       userLogin.setMasteruser(masteruser);
      //  userLoginRepository.save(userLogin);

        return kycdetails2;
    }

    public String uploadImage(String path, MultipartFile file) throws IOException {

        //Extract File Name

        String name = file.getOriginalFilename();

        //random Name Generate

        String randomId = UUID.randomUUID().toString();
        String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));

        //Provide FileName to Full Path
        String filePath = path+ File.separator +fileName1;

        //Create Folder If Not Already Exist
        File newFile = new File(path);

        if(!newFile.exists()) {
            newFile.mkdir();
        }

        //Copy File
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    public InputStream getResource(String path, String fileName) throws FileNotFoundException {


        String fullPath = path + File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);


        //db logic to return inputStream

        return is;
    }


}
