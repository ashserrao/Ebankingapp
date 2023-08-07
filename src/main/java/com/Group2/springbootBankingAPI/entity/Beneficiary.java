package com.Group2.springbootBankingAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "beneficiary")
public class Beneficiary
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String beneficiary_name;
    private String bank_name;
    private String beneficiary_accno;
    private String max_limit;

    @OneToOne
    @JsonIgnore
    private  Masteruser masteruser;
}
