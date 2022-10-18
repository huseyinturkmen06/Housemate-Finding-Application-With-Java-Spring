package com.example.newProject.api.Controllers;

import com.example.newProject.DTOs.Requests.HouseOwnerCreateRequest;
import com.example.newProject.DTOs.Requests.HouseOwnerUpdateRequest;
import com.example.newProject.Services.HouseOwnerService;
import com.example.newProject.Entities.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.util.LangUtil.split;

@CrossOrigin
@RestController
@RequestMapping("/houseOwners")
public class HouseOwnerController {

    private HouseOwnerService houseOwnerService;

    @Autowired
    public HouseOwnerController(HouseOwnerService houseOwnerService) {
        this.houseOwnerService = houseOwnerService;
    }

    @GetMapping
    public List<HouseOwner> getAll() {
        return houseOwnerService.getAll();
    }

    @GetMapping("/HouseOwnergetByHouseOwnerIdAndHouse_HouseId")
    public HouseOwner getByHouseOwnerIdAndHouse_HouseId(@RequestParam int ownerId, @RequestParam int houseId){
        return this.houseOwnerService.getByOwnerIdAndHouse_HouseId(ownerId,houseId);
    }

    //getByOwnerName
    @GetMapping("/{ownerName}")
    HouseOwner getByOwnerName(@PathVariable String ownerName){
        return this.houseOwnerService.getByOwnerName(ownerName);
    }
    //buradaki this, JPA ile gelen nesneyi temsil eder
    //yani JPA nesnesine ve dolayısı ile Entity'lere - tablolara erişebilmek için
    //this. yazmak zorundayız

    //getOwnerByOwnerId
    @GetMapping("/{ownerId}")
    public HouseOwner getOwnerByOwnerId(@PathVariable int ownerId){
        return houseOwnerService.getOwnerByOwnerId(ownerId);
    }

    @PostMapping
    public void createOneOwner(@RequestBody HouseOwnerCreateRequest houseOwnerCreateRequest){
        houseOwnerService.createOneOwner(houseOwnerCreateRequest);
    }

    @PostMapping("/saveOwnerMet2")
    public void createOneOwner2(@RequestBody HouseOwner houseOwner){
        houseOwnerService.createOneOwner2(houseOwner);
    }

    @PutMapping("/{ownerId}")
    public void updateOwnerByOwnerId(@PathVariable int ownerId,
                                     @RequestBody HouseOwnerUpdateRequest houseOwnerUpdateRequest){
        houseOwnerService.updateOwnerByOwnerId(ownerId,houseOwnerUpdateRequest);
    }



    @GetMapping("/getSomeOwners/{houseOwnersText}")
    public List<HouseOwner> getSomeOwners(@PathVariable String houseOwnersText ){

        return houseOwnerService.getSomeOwners(houseOwnersText);

    }



}
