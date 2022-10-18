package com.example.newProject.Entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class    BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int Id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_surname")
    private String customerSurname;

    @Column(name="customer_age")
    private int customerAge;

    @Column(name="customer_hometown")
    private String customerHometown;

    @Column(name="customer_department")
    private String customerDepartment;

    @Column(name="customer_grade")
    private int customerGrade;

    @Column(name="customer_phone")
    private int customerPhone;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="customer_gender")
    private String customerGender;
}
