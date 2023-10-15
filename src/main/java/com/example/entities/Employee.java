package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity

public class Employee extends User{

    public Employee(String email, String password) {
        super(email, password);
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{}";
    }
}
