package com.example.newProject.dataAccess.abstracts;
import com.example.newProject.entities.concretes.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseDao extends JpaRepository<House,Integer> {

   //House getByHouseOwner_OwnerId(int ownerId);
    House getByHouseId(int houseId);

    House getByOwnerId(int ownerId);


}