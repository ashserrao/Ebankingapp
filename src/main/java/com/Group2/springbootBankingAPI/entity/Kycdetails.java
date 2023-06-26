package com.Group2.springbootBankingAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name="mkyc_details")
public class Kycdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int kyc_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_user_id", referencedColumnName = "user_id")
    private Masteruser master_user;
    private String pan_no;
    private String aadhar_no;
    @Column(nullable = true, length = 64)
    private String cus_photo;

    //Getter and setter methods


    public int getKyc_id() {
        return kyc_id;
    }

    public void setKyc_id(int kyc_id) {
        this.kyc_id = kyc_id;
    }

    public Masteruser getMaster_user() {
        return master_user;
    }

    public void setMaster_user(Masteruser master_user) {
        this.master_user = master_user;
    }

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getAadhar_no() {
        return aadhar_no;
    }

    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public String getCus_photo() {
        return cus_photo;
    }

    public void setCus_photo(String cus_photo) {
        this.cus_photo = cus_photo;
    }
}