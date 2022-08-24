package com.example.newProject.dataAccess.abstracts;
import com.example.newProject.entities.concretes.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseOwnerDao extends JpaRepository<HouseOwner,Integer> {

HouseOwner getByOwnerIdAndHouse_HouseId(int ownerId,int houseId);

HouseOwner getByOwnerName(String ownerName);


}