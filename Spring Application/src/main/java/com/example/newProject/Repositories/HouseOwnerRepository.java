package com.example.newProject.Repositories;
import com.example.newProject.Entities.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseOwnerRepository extends JpaRepository<HouseOwner,Integer> {

HouseOwner getByOwnerIdAndHouse_HouseId(int ownerId,int houseId);

HouseOwner getByOwnerName(String ownerName);


}