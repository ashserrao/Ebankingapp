package com.Group2.springbootBankingAPI.controller;

import com.Group2.springbootBankingAPI.dto.AuthRequest;
import com.Group2.springbootBankingAPI.dto.KycdetailsDto;
import com.Group2.springbootBankingAPI.dto.MasteruserDto;

import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.service.BankingService;
import com.Group2.springbootBankingAPI.service.BeneficiaryService;
import com.Group2.springbootBankingAPI.service.JwtService;
import com.Group2.springbootBankingAPI.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/userRegistration")
    public @ResponseBody String UserRegistration(@RequestBody UserLogin userLogin){
        this.userLoginService.LoginRegistration(userLogin);
        return "Registration Successful ";

    }



//    @PostMapping("/createUser/{userLoginId}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public MasteruserDto BankingSave(@RequestBody MasteruserDto masteruser,@PathVariable Long userLoginId)
//    {
//        return bankingService.SaveUser(masteruser,userLoginId);
//    }

    @PostMapping("/{userId}/createKyc")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<KycdetailsDto> createKyc(@RequestBody KycdetailsDto kycdetailsDto, @PathVariable Integer userId)
    {
        KycdetailsDto createdKyc =  this.bankingService.SaveKyc(kycdetailsDto,userId);
        return new ResponseEntity<KycdetailsDto>(createdKyc, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/addBeneficiary")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public String addBeneficiary (@RequestBody Beneficiary beneficiary,@PathVariable Integer userId){
        return this.beneficiaryService.addBeneficiary(beneficiary,userId);

    }


    @GetMapping("/{userId}/getBeneficiary")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public Beneficiary getBeneficiary (@PathVariable Integer userId){
        return this.beneficiaryService.getBeneficiaryByuserId(userId);

    }

//    @CrossOrigin("*")
//
//    @GetMapping ("/getUsers")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<MasteruserDto> getAllUsers()
//    {
//         return this.bankingService.getAllUser();
//
//    }

   // @GetMapping("/getUserByUsername")

    @CrossOrigin("*")
    @RequestMapping(value = "/getUserByUsername", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @PreAuthorize("hasAuthority('ROLE_USER')or hasAuthority('ROLE_ADMIN')")
    public UserLogin getUserDetails(@AuthenticationPrincipal UserDetails userDetails)
    {
        String username = userDetails.getUsername();
        // Retrieve the user details based on the username or other identifier
       UserLogin userLogin = userLoginService.getUserByUsername(username);
        // Retrieve the user details based on the username or other identifier
      return userLogin;
    }

    @CrossOrigin("*")
    @RequestMapping(value = "/getAllUsers", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserLogin> getAllLoginUsers()
    {
        List<UserLogin> userLogins =   this.userLoginService.getAllLoginUsers();
        return userLogins;
    }


//    @CrossOrigin("*")
//    @RequestMapping(value = "/getUsers", method = {RequestMethod.GET, RequestMethod.OPTIONS})
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<MasteruserDto> getAllUsers() {
//        return this.bankingService.getAllUser();
//    }

//    @GetMapping ("/{userId}")
//    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
//    public MasteruserDto getUserById(@PathVariable Integer userId)
//    {
//        return this.bankingService.getUserId(userId);
//
//    }

    @GetMapping ("/getKycdetails")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<KycdetailsDto> getAllKycdetails()
    {
        return this.bankingService.getAllKycdetails();

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

