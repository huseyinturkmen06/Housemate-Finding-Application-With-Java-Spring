package com.example.newProject.DTOs.Requests;

import com.example.newProject.Entities.HouseOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class HouseSaveRequest {


    private String houseAddress    ;

    private int countOfBathroom;

    private int countOfBedroom;

    private int countOfSalon;

    private int countOfOwner;

    private String heatResource;

    private String furnished;

    private String internetPaved;

    private int floor;

    private int rent;

    private String ownerIds;
    //burası patlayabilir




}
