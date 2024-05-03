package com.example.vaadinproject.Backend.Repository;

import com.example.vaadinproject.Backend.Models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}
