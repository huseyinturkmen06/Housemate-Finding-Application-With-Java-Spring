package com.example.newProject.api.controller;


import com.example.newProject.business.abstarcts.CustomerService;
import com.example.newProject.dataAccess.abstracts.HouseDao;
import com.example.newProject.entities.concretes.Customer;
import com.example.newProject.entities.concretes.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/getall")
    public List<Customer> getall() {
        return this.customerService.getall();
    }

    @PostMapping("/add")
    public Customer add(@RequestBody Customer customer) {
         this.customerService.add(customer);
         return null;
//        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }




    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        this.customerService.add(customer);
        return null;

    }













}
