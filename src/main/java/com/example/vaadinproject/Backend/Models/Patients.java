package com.example.vaadinproject.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Entity(name = "patients")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Patients extends  AbstractEntity{
    @Column(unique = true)
    private String patientNumber;
    @NotNull
    @NotEmpty
    private String fullName;

    private LocalDate dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String occupation;
    @NotEmpty@NotNull
    private String address;
    @NumberFormat@NotEmpty@NotNull
    private String phoneNumber;
    @Email
    private String emailAddress;
    @NotEmpty@NotNull
    private String emergencyContactName;
    private String emergencyContactRelationship;
    private String emergencyContactPhoneNumber;
    private String primaryCarePhysician;
    private String allergies;
    private String chronicCondition;
    private String previousSurgeries;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Accounts accounts;


}
