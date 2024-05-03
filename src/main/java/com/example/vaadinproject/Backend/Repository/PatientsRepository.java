package com.example.vaadinproject.Backend.Repository;

import com.example.vaadinproject.Backend.Models.Accounts;
import com.example.vaadinproject.Backend.Models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
}
