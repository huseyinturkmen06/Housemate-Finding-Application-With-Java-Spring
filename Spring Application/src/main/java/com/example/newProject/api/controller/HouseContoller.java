package com.example.newProject.api.controller;


import com.example.newProject.business.abstarcts.HouseService;
import com.example.newProject.dataAccess.abstracts.HouseDao;
import com.example.newProject.entities.concretes.House;
import com.example.newProject.entities.concretes.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/house")
public class HouseContoller {

    @Autowired
    private HouseService houseService;

    private HouseDao houseDao;

    @GetMapping("/getall")
    public List<House> getall(){
        return this.houseService.getall();
    }

    @GetMapping("/getByHouseId")
    public House getByHouseId(@RequestParam int houseId){
         return this.houseService.getByHouseId(houseId);
    }



    @PostMapping("/add")
    public House add(@RequestBody House house){
        return this.houseService.add(house);
    }



    @GetMapping("/getByOwnerId")
    public House getByOwnerId(@RequestParam int ownerId){
        return this.houseDao.getByOwnerId(ownerId);
    }

}
