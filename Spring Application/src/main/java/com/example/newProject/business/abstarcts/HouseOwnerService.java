package com.example.newProject.business.abstarcts;

import com.example.newProject.entities.concretes.Customer;
import com.example.newProject.entities.concretes.HouseOwner;

public interface HouseOwnerService {

    public HouseOwner getall();

    HouseOwner getByOwnerIdAndHouse_HouseId(int ownerId,int houseId);

    HouseOwner getByOwnerName(String ownerName);


}
