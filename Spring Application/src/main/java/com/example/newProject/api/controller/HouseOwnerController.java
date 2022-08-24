package com.example.newProject.api.controller;

import com.example.newProject.business.abstarcts.HouseOwnerService;
import com.example.newProject.dataAccess.abstracts.HouseOwnerDao;
import com.example.newProject.entities.concretes.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/houseOwner")
public class HouseOwnerController {

    private HouseOwnerService houseOwnerService;

    @Autowired
    private HouseOwnerDao houseOwnerDao;

    @Autowired
    public HouseOwnerController(HouseOwnerService houseOwnerService) {
        this.houseOwnerService = houseOwnerService;
    }

    @GetMapping("/HouseOwnergetByHouseOwnerIdAndHouse_HouseId")
    public HouseOwner getByHouseOwnerIdAndHouse_HouseId(@RequestParam int ownerId, @RequestParam int houseId){
        return this.houseOwnerService.getByOwnerIdAndHouse_HouseId(ownerId,houseId);
    }

    @GetMapping("/getall")
    public List<HouseOwner> demo(){
        return this.houseOwnerDao.findAll();
    }


    @GetMapping("/getByOwnerName")
    HouseOwner getByOwnerName(@RequestParam String ownerName){
        return this.houseOwnerDao.getByOwnerName(ownerName);
    }
    //buradaki this, JPA ile gelen nesneyi temsil eder
    //yani JPA nesnesine ve dolayısı ile Entity'lere - tablolara erişebilmek için
    //this. yazmak zorundayız


}
