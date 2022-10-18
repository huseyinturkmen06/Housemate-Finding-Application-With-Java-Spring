package com.example.newProject.api.Controllers;


import com.example.newProject.DTOs.Requests.HouseSaveRequest;
import com.example.newProject.Entities.HouseOwner;
import com.example.newProject.Services.HouseService;
import com.example.newProject.Repositories.HouseRepository;
import com.example.newProject.Entities.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/houses")
public class HouseContoller {


    private HouseService houseService;
    private HouseRepository houseRepository;

    @Autowired
    public HouseContoller(HouseService houseService, HouseRepository houseRepository) {
        this.houseService = houseService;
        this.houseRepository = houseRepository;
    }



    //getAll
    @GetMapping
    public List<House> getAll(){
        return this.houseService.getAll();
    }

    //getOneHouseByHouseId
    @GetMapping("/{houseId}")
    public House getByHouseId(@PathVariable int houseId){
         return houseService.getByHouseId(houseId);
    }

    //getOneHouseByOwnerId
    @GetMapping("/byOwner/{ownerId}")
    public House getOneHouseByOwnerId(@PathVariable int ownerId){
        return this.houseService.getOneHouseByOwnerId(ownerId);
    }

    //getOneHouseByCustomerId
    @GetMapping("/byCustomer/{customerId}")
    public House getOneHouseByCustomerId(@PathVariable int customerId){
        return this.houseService.getOneHouseByCustomerId(customerId);
    }

    //normalde ya bir eve aynı anda birden fazla müşteri gelirse diye düşünmüştüm ama
    //zaten ev yeni kaydedilirken müşterisi olmaz
    //müşteri sistemdeki evi görür ve sonradan kaydolur
    //ancak eve yani kayıt yapılırken birden çok house owner girilebilir
    //onun için house ownerları dikkate almalıyız

    //save
    @PostMapping
    public House saveOneHouse(@RequestBody HouseSaveRequest houseSaveRequest){
        return this.houseService.saveOneHouse(houseSaveRequest);
    }



    //update
    @PutMapping("/{houseId}")
    public House updateOneHouseById(@RequestBody HouseSaveRequest houseSaveRequest,
                                    @PathVariable int houseId){
        return houseService.updateOneHouseById(houseSaveRequest,houseId);
    }




}
