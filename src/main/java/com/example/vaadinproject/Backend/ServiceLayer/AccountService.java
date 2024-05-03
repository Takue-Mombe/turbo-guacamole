package com.example.vaadinproject.Backend.ServiceLayer;


import com.example.vaadinproject.Backend.Models.Accounts;
import com.example.vaadinproject.Backend.Repository.AccountsRepository;
import com.example.vaadinproject.Backend.Repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountsRepository accountsRepository;
    private final PatientsRepository patientsRepository;

    @Autowired
    public AccountService(AccountsRepository accountsRepository, PatientsRepository patientsRepository) {
        this.accountsRepository = accountsRepository;
        this.patientsRepository = patientsRepository;
    }

    public List<Accounts> getAll(){
       return accountsRepository.findAll();
    }
    public Long count(){
        return accountsRepository.count();
    }
    public void delete(Accounts accounts){
        accountsRepository.delete(accounts);
    }
    public void save(Accounts accounts){
        if(accounts.getPatient().getPatientNumber().equals(accounts.getPatientNumber())){
            accountsRepository.save(accounts);

        }else {
            System.out.println("Error");
        }
    }
}
