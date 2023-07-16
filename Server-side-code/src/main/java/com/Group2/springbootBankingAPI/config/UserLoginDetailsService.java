package com.Group2.springbootBankingAPI.config;

import com.Group2.springbootBankingAPI.entity.UserLogin;

import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLogin> userLogin = loginRepository.findByEmail(username);


        return userLogin.map(UserLoginDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}

