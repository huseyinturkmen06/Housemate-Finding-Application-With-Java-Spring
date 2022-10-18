package com.example.newProject.Services;

import com.example.newProject.DTOs.Requests.HouseSaveRequest;
import com.example.newProject.Repositories.HouseRepository;
import com.example.newProject.Entities.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private HouseRepository houseRepository;

    private HouseOwnerService houseOwnerService;

    @Autowired
    public HouseService(HouseRepository houseRepository,HouseOwnerService houseOwnerService) {
        this.houseRepository = houseRepository;
        this.houseOwnerService=houseOwnerService;
    }

//getall
    public List<House> getAll() {
        return this.houseRepository.findAll();
    }


    public House getByHouseId(int houseId) {

        return houseRepository.findByHouseId(houseId);

    }

    public House getOneHouseByOwnerId(int ownerId){
        return houseRepository.getByOwnerId(ownerId);
    }

    public House getOneHouseByCustomerId(int customerId){
        return houseRepository.getByCustomerId(customerId);
    }

    //saveOneHouse
    public House saveOneHouse(HouseSaveRequest houseSaveRequest) {
        House houseToSave= new House();
        houseToSave.setHouseAddress(houseSaveRequest.getHouseAddress());
        houseToSave.setCountOfBedroom(houseSaveRequest.getCountOfBedroom());
        houseToSave.setCountOfBathroom(houseSaveRequest.getCountOfBathroom());
        houseToSave.setCountOfSalon(houseSaveRequest.getCountOfSalon());
        houseToSave.setCountOfOwner(houseSaveRequest.getCountOfOwner());
        houseToSave.setHeatResource(houseSaveRequest.getHeatResource());
        houseToSave.setFurnished(houseSaveRequest.getFurnished());
        houseToSave.setInternetPaved(houseSaveRequest.getInternetPaved());
        houseToSave.setFloor(houseSaveRequest.getFloor());
        houseToSave.setRent(houseSaveRequest.getRent());

        if(houseOwnerService.getSomeOwners(houseSaveRequest.getOwnerIds())!=null){
            houseToSave.setOwnerId(houseOwnerService.getSomeOwners(houseSaveRequest.getOwnerIds()));
        }
        return houseRepository.save(houseToSave);

    }

    public House updateOneHouseById(HouseSaveRequest houseSaveRequest,int houseId){
        House houseToSave = houseRepository.findById(houseId).orElse(null);
        if(houseToSave!=null){
            houseToSave.setHouseAddress(houseSaveRequest.getHouseAddress());
            houseToSave.setCountOfBedroom(houseSaveRequest.getCountOfBedroom());
            houseToSave.setCountOfBathroom(houseSaveRequest.getCountOfBathroom());
            houseToSave.setCountOfSalon(houseSaveRequest.getCountOfSalon());
            houseToSave.setCountOfOwner(houseSaveRequest.getCountOfOwner());
            houseToSave.setHeatResource(houseSaveRequest.getHeatResource());
            houseToSave.setFurnished(houseSaveRequest.getFurnished());
            houseToSave.setInternetPaved(houseSaveRequest.getInternetPaved());
            houseToSave.setFloor(houseSaveRequest.getFloor());
            houseToSave.setRent(houseSaveRequest.getRent());
            if(houseOwnerService.getSomeOwners(houseSaveRequest.getOwnerIds())!=null){
                houseToSave.setOwnerId(houseOwnerService.getSomeOwners(houseSaveRequest.getOwnerIds()));
            }

        }
        return houseRepository.save(houseToSave);


    }





}
