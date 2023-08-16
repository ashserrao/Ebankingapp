package com.Group2.springbootBankingAPI.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Table2")
public class MasterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column(name="fName")
    private String first_name;
    private String last_name;
    private String dob;
    private String permanent_add;
    private String residential_add;

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
}
