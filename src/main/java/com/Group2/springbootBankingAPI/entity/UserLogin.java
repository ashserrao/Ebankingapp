package com.Group2.springbootBankingAPI.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User_Login")
public class UserLogin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_no;
    private String date_of_birth;
    private String permanent_add;
    private String residential_add;
    private String role;

    @OneToOne
  //  @JsonIgnore
    private  Masteruser masteruser;

   @OneToOne
    private Beneficiary beneficiary;
}
