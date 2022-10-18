package com.example.newProject.Repositories;
import com.example.newProject.Entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Integer> {

   //House getByHouseOwner_OwnerId(int ownerId);
//    House getByHouseId(int houseId);

    House findByHouseId(int houseId);

    House getByOwnerId(int ownerId);

    House getByCustomerId(int customerId);


}