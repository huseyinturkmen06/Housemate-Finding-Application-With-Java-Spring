package com.example.newProject.business.abstarcts;

import com.example.newProject.entities.concretes.Customer;
import com.example.newProject.entities.concretes.House;

import java.util.List;

public interface HouseService {

    public List<House> getall();

    House add(House house);

    public House getByHouseId(int houseId);


}
