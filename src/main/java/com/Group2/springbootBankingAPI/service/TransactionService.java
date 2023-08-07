package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Masteruser;
import com.Group2.springbootBankingAPI.entity.Transactions;
import com.Group2.springbootBankingAPI.exceptions.ResourceNotFoundException;
import com.Group2.springbootBankingAPI.repository.BankingRepo;
import com.Group2.springbootBankingAPI.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BankingRepo bankingRepo;

    public String getLocalDate(){
        // Get the current LocalDate
        LocalDate currentDate = LocalDate.now();

        // Define a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the LocalDate as a String
        String dateString = currentDate.format(formatter);
        return dateString;
    }
//    public  Masteruser updateCreditTransactionsByuserId(Transactions transactions, Integer userId)
//    {
//
//
//             Masteruser masteruser= this.bankingRepo.findById(userId).orElseThrow(
//                                       () -> new RuntimeException("User not found"));
//
//              Transactions transactions1 = new Transactions();
//                transactions1.setDateOfLastTransaction(getLocalDate());
//                transactions1.setCreditAmount(transactions.getCreditAmount());
//                masteruser.setCurrent_Balance(masteruser.getCurrent_Balance()+transactions.getCreditAmount());
//                transactions1.setLastTransactionDetails
//                        ("₹"+transactions.getCreditAmount()+"  is credited to Account No. "
//                                +masteruser.getAccount_Number());
//                transactions1.setMasteruser(masteruser);
//              Transactions transactions2 =  transactionRepository.save(transactions1);
//              List<Transactions> transactionsList = new ArrayList<>();
//              transactionsList.add(transactions2);
//              masteruser.setTransactions(transactionsList);
//              return   bankingRepo.save(masteruser);
//
//    }


    public Masteruser updateCreditTransactionsByuserId(Transactions transactions, Integer userId) {
        Masteruser masteruser = this.bankingRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId));

        Transactions newTransaction = new Transactions();
        newTransaction.setDateOfLastTransaction(getLocalDate());
        newTransaction.setCreditAmount(transactions.getCreditAmount());
        masteruser.setCurrent_Balance(masteruser.getCurrent_Balance() + transactions.getCreditAmount());
        newTransaction.setLastTransactionDetails("₹" + transactions.getCreditAmount() + " is credited to Account No. " + masteruser.getAccount_Number());
        newTransaction.setMasteruser(masteruser);

        // Retrieve the existing Transactions array from masteruser
        List<Transactions> transactionsList = masteruser.getTransactions();

        // Add the newTransaction to the existing array
        transactionsList.add(newTransaction);

        // Save the newTransaction to the database
        Transactions savedTransaction = transactionRepository.save(newTransaction);

        // Save the updated transactionsList back to the masteruser
        masteruser.setTransactions(transactionsList);

        // Save the masteruser to the database
        return bankingRepo.save(masteruser);
    }

    public Masteruser updateDebitTransactionsByuserId(Transactions transactions, Integer userId)
    {


        Masteruser masteruser= this.bankingRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User","id",userId));

        Transactions transactions1 = new Transactions();
        transactions1.setDateOfLastTransaction(getLocalDate());
        transactions1.setDebitAmount(transactions.getDebitAmount());
        masteruser.setCurrent_Balance(masteruser.getCurrent_Balance() - transactions.getDebitAmount());
        transactions1.setLastTransactionDetails
                ("₹"+transactions.getDebitAmount()+"  is debited from Account No. "
                        +masteruser.getAccount_Number());
        transactions1.setMasteruser(masteruser);
        Transactions transactions2 =  transactionRepository.save(transactions1);
        List<Transactions> transactionsList = new ArrayList<>();
        transactionsList.add(transactions2);
        masteruser.setTransactions(transactionsList);
        return bankingRepo.save(masteruser);

    }
}
