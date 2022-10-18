package com.example.newProject.Services;

import com.example.newProject.DTOs.Requests.HouseOwnerCreateRequest;
import com.example.newProject.DTOs.Requests.HouseOwnerUpdateRequest;
import com.example.newProject.Entities.House;
import com.example.newProject.Repositories.HouseOwnerRepository;
import com.example.newProject.Entities.HouseOwner;
import com.example.newProject.Repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseOwnerService {

    HouseOwnerRepository houseOwnerRepository;
    HouseRepository houseRepository;

    @Autowired
    public HouseOwnerService(HouseOwnerRepository houseOwnerRepository,HouseRepository houseRepository) {
        this.houseOwnerRepository = houseOwnerRepository;
        this.houseRepository =houseRepository;
    }

//getAll
    public List<HouseOwner> getAll() {
        return houseOwnerRepository.findAll();
    }


    public HouseOwner getByOwnerIdAndHouse_HouseId(int ownerId, int houseId) {
        return this.houseOwnerRepository.getByOwnerIdAndHouse_HouseId(ownerId,houseId);
    }


    public HouseOwner getByOwnerName(String ownerName) {
        return this.houseOwnerRepository.getByOwnerName(ownerName);
    }



    public HouseOwner getOwnerByOwnerId(int ownerId){
        return houseOwnerRepository.findById(ownerId).orElse(null);
    }


    //nir kişinin ev sahibi olabilmesi için
    //kişinin houseId sinin house tablosunda karşılığı olması gerekir
    public void createOneOwner(HouseOwnerCreateRequest houseOwnerCreateRequest){
        int houseId= houseOwnerCreateRequest.getHouseId();
        House house= houseRepository.findByHouseId(houseId);

        HouseOwner houseOwnerTosave = new HouseOwner();
        if(house!=null){
//            houseOwnerTosave.setOwnerId(houseOwnerRequest.getOwnerId());
            houseOwnerTosave.setOwnerName(houseOwnerCreateRequest.getOwnerName());
            houseOwnerTosave.setOwnerSurname(houseOwnerCreateRequest.getOwnerSurname());
            houseOwnerTosave.setOwnerAge(houseOwnerCreateRequest.getOwnerAge());
            houseOwnerTosave.setOwnerHometown(houseOwnerCreateRequest.getOwnerHometown());
            houseOwnerTosave.setOwnerGrade(houseOwnerCreateRequest.getOwnerGrade());
            houseOwnerTosave.setOwnerDepatment(houseOwnerCreateRequest.getOwnerDepatment());
            houseOwnerTosave.setOwnerPhone(houseOwnerCreateRequest.getOwnerPhone());
            houseOwnerTosave.setOwnerMail(houseOwnerCreateRequest.getOwnerMail());
            houseOwnerTosave.setOwnerGender(houseOwnerCreateRequest.getOwnerGender());
            houseOwnerTosave.setHouse(house); //denemelik

            houseOwnerRepository.save(houseOwnerTosave);

        }
        else{

            System.out.println("böyle bir ev yok");
            System.out.println(houseOwnerCreateRequest.getHouseId());
        }
    }

    public void updateOwnerByOwnerId( int ownerId, HouseOwnerUpdateRequest houseOwnerUpdateRequest){
        HouseOwner houseOwnerTosave=houseOwnerRepository.findById(ownerId).orElse(null);
        int houseId= houseOwnerUpdateRequest.getHouseId();
        House house= houseRepository.findByHouseId(houseId);

        if(houseOwnerTosave!=null&&house!=null){
            //owner için yalnızca bu özellikleri güncellemek istemişiz
            houseOwnerTosave.setOwnerAge(houseOwnerUpdateRequest.getOwnerAge());
            houseOwnerTosave.setOwnerGrade(houseOwnerUpdateRequest.getOwnerGrade());
            houseOwnerTosave.setOwnerPhone(houseOwnerUpdateRequest.getOwnerPhone());
            houseOwnerTosave.setOwnerMail(houseOwnerUpdateRequest.getOwnerMail());
            houseOwnerTosave.setHouse(house);
            houseOwnerRepository.save(houseOwnerTosave);

        } else if (houseOwnerTosave==null&&house!=null) {
            System.out.println("böyle bir kullanıcı yok");
        }
        else if(houseOwnerTosave!=null&&house==null){
            System.out.println("böyle bir ev yok");
        }
        else{
            System.out.println("hem kullanıcı hem de ev yok");
        }
    }

    public void createOneOwner2(@RequestBody HouseOwner houseOwner){
        houseOwnerRepository.save(houseOwner);
    }


    //birden çok ama belli ownerları getir
    public List<HouseOwner> getSomeOwners(String houseOwnersText){

//        System.out.println(houseOwnersText);
//        ArrayList<Integer> houseOwners=new ArrayList<>();//??

        String[] stringArray=houseOwnersText.split(",");  //["1","2","3"]
        ArrayList<Integer> ownerIdentications= new ArrayList<>();

        //String listesini int listesine çavirdim
        for(String text:stringArray){
            ownerIdentications.add(Integer.parseInt(text));
        }
        return houseOwnerRepository.findAllById(ownerIdentications);
    }


}
