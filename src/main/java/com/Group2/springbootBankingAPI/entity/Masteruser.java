package com.Group2.springbootBankingAPI.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Masteruser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String account_Number;

    private double current_Balance;



 @OneToOne(mappedBy = "masteruser",cascade = CascadeType.ALL)
   private Kycdetails kycdetails;
 @JsonIgnore
 @OneToOne(mappedBy ="masteruser", cascade=CascadeType.ALL)
 private UserLogin userLogin;

 @OneToMany (mappedBy="masteruser",cascade=CascadeType.ALL)
 private List<Transactions> transactions = new ArrayList<>();





}
