package com.example.vaadinproject.Backend.ServiceLayer;

import com.example.vaadinproject.Backend.Models.Patients;
import com.example.vaadinproject.Backend.Repository.PatientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class PatientService {
    private final PatientsRepository patientsRepository;

    public List<Patients>getAll(){
        return patientsRepository.findAll();
    }
    public void save(Patients patients){
        patientsRepository.save(patients);
        System.out.println(patients.getPatientNumber());
    }
    public void delete(Patients patients){
        System.out.println(patients.getPatientNumber());
        patientsRepository.delete(patients);
    }
}
