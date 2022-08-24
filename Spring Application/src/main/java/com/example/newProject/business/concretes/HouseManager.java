package com.example.newProject.business.concretes;

import com.example.newProject.business.abstarcts.HouseService;
import com.example.newProject.dataAccess.abstracts.HouseDao;
import com.example.newProject.entities.concretes.Customer;
import com.example.newProject.entities.concretes.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HouseManager implements HouseService {

    HouseDao houseDao;

    @Autowired
    public HouseManager(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    @Override
    public List<House> getall() {
        return this.houseDao.findAll();
    }

    @Override
    public House add(House house) {
        return this.houseDao.save(house);
    }

    @Override
    public House getByHouseId(int houseId) {
        return this.houseDao.getByHouseId(houseId);
    }


}
