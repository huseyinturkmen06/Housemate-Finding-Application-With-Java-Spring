package com.example.newProject.DTOs.Requests;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerSaveRequest {

    private Integer customerId;

    private String customerName;


    private String customerSurname;

    private Integer customerAge;


    private String customerHometown;


    private String customerDepartment;


    private Integer customerGrade;


    private Integer customerPhone;


    private String customerEmail;


    private String customerGender;

    private Integer houseId;
}
