package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.dto.AuthRequest;
import com.Group2.springbootBankingAPI.entity.*;
import com.Group2.springbootBankingAPI.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class BankingController {

    @Autowired
    BankingService bankingService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
     private BeneficiaryService beneficiaryService;

    @Autowired
    private KycService kycService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/userRegistration")
    public  ResponseEntity<UserLogin> UserRegistration(@RequestBody UserLogin userLogin){
        UserLogin createdUserLogin =  this.userLoginService.LoginRegistration(userLogin);
        return new ResponseEntity<UserLogin>(createdUserLogin,HttpStatus.CREATED);

    }


    @CrossOrigin("*")
    @PutMapping("/updateBeneficiary/{beneficiaryId}")
    public ResponseEntity<Beneficiary> updateBeneficiaryById(@RequestBody Beneficiary beneficiary,
                                                @PathVariable Integer beneficiaryId){
        Beneficiary updatedBeneficiary = this.beneficiaryService.updateBeneficiaryById(beneficiary,beneficiaryId);
       return  new ResponseEntity<Beneficiary>(updatedBeneficiary,HttpStatus.OK);


    }
    @CrossOrigin("*")
    @PutMapping("/updateKyc/{kycId}")
    public ResponseEntity<Kycdetails> updateKycdetailsById(@RequestBody Kycdetails kycdetails,
                                                          @PathVariable Integer kycId)
    {
        Kycdetails updatedKycdetails=this.kycService.updateKycdetailsById(kycdetails,kycId);
       return new ResponseEntity<Kycdetails>(updatedKycdetails,HttpStatus.OK);

    }

    @CrossOrigin("*")
    @PostMapping("/updateCreditTransaction/{userId}")
    public ResponseEntity<Masteruser> updateCreditTransactionsByuserId
            (@RequestBody Transactions transactions,@PathVariable Integer userId)
    {
         Masteruser masteruser= this.transactionService.updateCreditTransactionsByuserId(transactions,userId);
        return new ResponseEntity<Masteruser>(masteruser,HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/updateDebitTransaction/{userId}")
    public ResponseEntity<Masteruser> updateDebitTransactionsByuserId
            (@RequestBody Transactions transactions,@PathVariable Integer userId)
    {
        Masteruser masteruser= this.transactionService.updateDebitTransactionsByuserId(transactions,userId);
        return new ResponseEntity<Masteruser>(masteruser,HttpStatus.OK);

    }





    @PostMapping("/{userId}/addBeneficiary")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Beneficiary> addBeneficiary (@RequestBody Beneficiary beneficiary,@PathVariable Integer userId){
        Beneficiary beneficiary1 = this.beneficiaryService.addBeneficiary(beneficiary,userId);
        return new ResponseEntity<Beneficiary>(beneficiary1, HttpStatus.CREATED);
    }




    @CrossOrigin("*")
    @RequestMapping(value = "/getUserByUsername", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @PreAuthorize("hasAuthority('ROLE_USER')or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<UserLogin> getUserDetails(@AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();

       UserLogin userLogin = userLoginService.getUserByUsername(username);

        return new ResponseEntity<UserLogin>(userLogin, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getAllUsers", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<List<UserLogin>> getAllLoginUsers()
    {
        List<UserLogin> userLogins =   this.userLoginService.getAllLoginUsers();
        return new ResponseEntity<List<UserLogin>>(userLogins, HttpStatus.OK);
    }






    //Post Image upload

    @Value("${project.image}")
    private String path;

    @CrossOrigin("*")
    @PostMapping("/imageUpload/{kycId}")
    public ResponseEntity<Kycdetails> fileUpload(
            @RequestParam("image") MultipartFile image,
            @PathVariable Integer kycId
    ) throws IOException
    {
        Kycdetails kycdetails = this.kycService.getKycdetailsById(kycId) ;
        String fileName = this.kycService.uploadImage(path,image);
        kycdetails.setCus_photo(fileName);

        Kycdetails updatedkycdetails = this.kycService.updateKycdetailsimageById(kycdetails, kycId);
        return new ResponseEntity<>(updatedkycdetails, HttpStatus.OK);


    }

    //method to serve files
    @CrossOrigin("*")
    @GetMapping(value="/imageServe/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName")
                                  String imageName, HttpServletResponse response) throws IOException
    {

        InputStream resource = this.kycService.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }



    @CrossOrigin("*")
    @RequestMapping(value = "/authenticate", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest)
    {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated())
        {
            return jwtService.generateToken(authRequest.getUsername());
        } else
        {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }
}

