package com.Group2.springbootBankingAPI.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master_user")
@Data
public class Masteruser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String account_Number;


//    One to one mapping user ID
 @OneToOne(mappedBy = "masteruser",cascade = CascadeType.ALL)
   private Kycdetails kycdetails;

 @OneToOne(mappedBy ="masteruser", cascade=CascadeType.ALL)
 private UserLogin userLogin;

 @JsonIgnore
 @OneToOne(mappedBy ="masteruser", cascade=CascadeType.ALL)
 private Beneficiary beneficiary;




}
