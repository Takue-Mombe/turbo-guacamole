package com.example.vaadinproject.Backend;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "patients")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Patients extends  AbstractEntity{
}
