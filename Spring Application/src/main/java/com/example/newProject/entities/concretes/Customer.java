package com.example.newProject.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

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
