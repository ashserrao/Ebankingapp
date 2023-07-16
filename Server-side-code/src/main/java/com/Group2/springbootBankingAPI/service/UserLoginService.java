package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.dto.MasteruserDto;
import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service

public class UserLoginService
{
    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    BankingRepo bankingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BankingRepo accountRepository;

    public String LoginRegistration(UserLogin userLogin)
    {
        // Generate account number
        String accountNumber = generateAccountNumber();

        // Save account number in the other table
        MasteruserDto masteruserDto = new MasteruserDto();
        masteruserDto.setAccount_Number(accountNumber);

        Masteruser masteruser= this.modelMapper.map(masteruserDto,Masteruser.class);
        accountRepository.save(masteruser);

        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        //userLogin.setMasteruser(masteruser1);
        UserLogin userLogin1 =  userLoginRepository.save(userLogin);





        return "Registration successful!";
    }

    public List<UserLogin> getAllLoginUsers()
   {
       List<UserLogin> userLogins = userLoginRepository.findAll();
        return userLogins;
    }

    public UserLogin getUserByUsername(String username)
    {
        UserLogin userLogin = userLoginRepository.findByEmail(username).orElseThrow(
                () -> new RuntimeException("User not found"));
        return userLogin;
    }





        private String generateAccountNumber()
        {
            StringBuilder accountNumberBuilder = new StringBuilder();
            // Add the desired prefix
            accountNumberBuilder.append("OMG233");
            // Generate a random number with 7 digits
            Random random = new Random();
            int randomNumber = random.nextInt(9000000) + 1000000;
            // Generates a number between 1000000 and 9999999

            // Append the random number to the account number
            accountNumberBuilder.append(randomNumber);

            // Return the generated account number
            return accountNumberBuilder.toString();

        }
    }





