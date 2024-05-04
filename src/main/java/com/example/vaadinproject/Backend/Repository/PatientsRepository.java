package com.example.vaadinproject.Backend.Repository;

import com.example.vaadinproject.Backend.Models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
    @Query("SELECT c FROM patients c WHERE LOWER(c.fullName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Patients> search(@Param("searchTerm") String searchTerm);
}