package com.Group2.springbootBankingAPI.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "master_user")
public class Masteruser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String first_name;
    private String last_name;
    private String dob;
//    @Column(nullable = false, length = 100)
    private String permanent_add;
//    @Column(nullable = true, length = 100)
    private String residential_add;
    private String city;
    private String state;
    private int pin_code;
    private String ph_no;
    private String email;
    private String password;
    private boolean user_stat;
    private boolean kyc_stat;

    // foreign key coding
//    One to one mapping user ID
//    @OneToOne(mappedBy = "master_user", cascade = CascadeType.ALL)
//    private Kycdetails kyc_details;

    //Getter and setter methods

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPermanent_add() {
        return permanent_add;
    }

    public void setPermanent_add(String permanent_add) {
        this.permanent_add = permanent_add;
    }

    public String getResidential_add() {
        return residential_add;
    }

    public void setResidential_add(String residential_add) {
        this.residential_add = residential_add;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPin_code() {
        return pin_code;
    }

    public void setPin_code(int pin_code) {
        this.pin_code = pin_code;
    }

    public String getPh_no() {
        return ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUser_stat() {
        return user_stat;
    }

    public void setUser_stat(boolean user_stat) {
        this.user_stat = user_stat;
    }

    public boolean isKyc_stat() {
        return kyc_stat;
    }

    public void setKyc_stat(boolean kyc_stat) {
        this.kyc_stat = kyc_stat;
    }
}
