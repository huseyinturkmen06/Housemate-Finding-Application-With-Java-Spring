package com.example.newProject.business.abstarcts;

import com.example.newProject.dataAccess.abstracts.HouseDao;
import com.example.newProject.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getall();
    //void save(Customer customer);

    Customer add(Customer customer);

    //içine customer alacağı için Customer cinsinden yazmamız gerekir sanırım
    Customer update(Customer customer);






}
