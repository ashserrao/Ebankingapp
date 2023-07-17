package com.Group2.springbootBankingAPI.dto;

import com.Group2.springbootBankingAPI.entity.Masteruser;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class KycdetailsDto
{

    private int kyc_id;
    private String pan_no;
    private String aadhar_no;
    private String cus_photo;
    private MasteruserDto masteruser;
}
