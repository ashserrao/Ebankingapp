package com.Group2.springbootBankingAPI.dto;

import com.Group2.springbootBankingAPI.entity.Beneficiary;
import com.Group2.springbootBankingAPI.entity.Kycdetails;
import com.Group2.springbootBankingAPI.entity.UserLogin;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class MasteruserDto
{
    private Long user_id;
    private String account_Number;
    private UserLogin userLogin;


}
