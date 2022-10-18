package com.example.newProject.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Customer {
//int yaparsan null hatası verebilir, Integer yap

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_surname")
    private String customerSurname;


    @Column(name="customer_age")
    private Integer customerAge;

    @Column(name="customer_hometown")
    private String customerHometown;

    @Column(name="customer_department")
    private String customerDepartment;

    @Column(name="customer_grade")
    private Integer customerGrade;

    @Column(name="customer_phone")
    private Integer customerPhone;

    @Column(name="customer_email")
    private String customerEmail;

    @Column(name="customer_gender")
    private String customerGender;

    @Nullable
    @ManyToOne()
    @JoinColumn(name="house_id")
    private House house;








}
