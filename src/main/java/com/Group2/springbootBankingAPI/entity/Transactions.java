package com.Group2.springbootBankingAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long TransactionId;
   // private double currentBalance;
    private String lastTransactionDetails;
    private String dateOfLastTransaction;
    private double creditAmount;
    private double debitAmount;
    @ManyToOne
    @JsonIgnore
    private  Masteruser masteruser;
}
