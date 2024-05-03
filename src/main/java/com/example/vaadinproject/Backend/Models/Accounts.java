package com.example.vaadinproject.Backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "accounts")@Getter@Setter
public class Accounts extends AbstractEntity{

    @NotNull@NotEmpty
    private Long AccountNumber;
    private String username;
    private String password;
    private double account_limit;
    private double amount;
    private String patientNumber;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patients patient;


}
