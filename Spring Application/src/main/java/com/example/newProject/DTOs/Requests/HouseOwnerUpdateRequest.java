package com.example.newProject.DTOs.Requests;

import lombok.Data;

@Data
public class HouseOwnerUpdateRequest {

    //ownerda neleri değiştirmek istersek onları dto ya koyuyoruz

    private int ownerAge;

    private String ownerGrade;

    private String ownerPhone;

    private String ownerMail;

  private int houseId;
}
