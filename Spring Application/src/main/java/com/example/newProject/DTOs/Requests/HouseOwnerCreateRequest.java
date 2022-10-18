package com.example.newProject.DTOs.Requests;

import lombok.Data;

@Data
public class HouseOwnerCreateRequest {

//    private int ownerId;

//belki crete yaparken dilruba gibi id de almak isteriz diye
    //id alanı da bıraktık
    //yoksa HouseOwnerUpdate ile aynı içeriğe sahip

    private String ownerName;


    private String ownerSurname;


    private int ownerAge;


    private String ownerHometown;


    private String ownerGrade;


    private String ownerDepatment;


    private String ownerPhone;


    private String ownerMail;


    private String ownerGender;


    private int houseId;

}

