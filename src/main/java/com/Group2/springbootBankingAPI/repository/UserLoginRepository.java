package com.Group2.springbootBankingAPI.repository;


import com.Group2.springbootBankingAPI.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long>
{
    Optional<UserLogin> findByEmail (String username);
}
