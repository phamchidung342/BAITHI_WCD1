package com.example.Test.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    private String employeeId;

    @Column(nullable = false, length = 64)
    private String employeeName;

    @Column(nullable = false)
    private String birthday;

    @Column(nullable = false, length = 11)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;
}