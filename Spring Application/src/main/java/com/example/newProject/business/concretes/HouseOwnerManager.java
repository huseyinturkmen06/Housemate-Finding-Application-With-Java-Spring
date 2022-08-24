package com.example.newProject.business.concretes;

import com.example.newProject.business.abstarcts.HouseOwnerService;
import com.example.newProject.dataAccess.abstracts.HouseOwnerDao;
import com.example.newProject.entities.concretes.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseOwnerManager implements HouseOwnerService {

    HouseOwnerDao houseOwnerDao;

    @Autowired
    public HouseOwnerManager(HouseOwnerDao houseOwnerDao) {
        this.houseOwnerDao = houseOwnerDao;
    }

    @Override
    public HouseOwner getall() {
        return null;
    }

    @Override
    public HouseOwner getByOwnerIdAndHouse_HouseId(int ownerId, int houseId) {
        return this.houseOwnerDao.getByOwnerIdAndHouse_HouseId(ownerId,houseId);
    }

    @Override
    public HouseOwner getByOwnerName(String ownerName) {
        return this.houseOwnerDao.getByOwnerName(ownerName);
    }


}
