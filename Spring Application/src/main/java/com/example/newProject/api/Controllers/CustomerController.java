package com.example.newProject.api.Controllers;


import com.example.newProject.DTOs.Requests.CustomerSaveRequest;
import com.example.newProject.Entities.HouseOwner;
import com.example.newProject.Services.CustomerService;
import com.example.newProject.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {



    CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;;
    }



    //get All
    @GetMapping
    public List<Customer> getAllCustomers() {
        return this.customerService.getall();
    }


    //getById
    @GetMapping("/{customerId}")
    public Customer getById(@PathVariable int customerId){
        return customerService.getOneCustomerById(customerId);
    }

    //save
//    @PostMapping
//    public void saveOneCustomer(@RequestBody CustomerSaveRequest customerSaveRequest) {
//
//         this.customerService.saveOneCustomer(customerSaveRequest);
//
////        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
//    }

    @PostMapping("/save2")
    public void saveOneCustomer2(@RequestBody Customer customer) {

        this.customerService.saveOneCustomer2(customer);

//        return (ResponseEntity) ResponseEntity.status(HttpStatus.CREATED);
    }


    //updateCustomerByCustomerId
    @PutMapping("/{customerId}")
    public void updateCustomerById(@RequestBody Customer customer,@PathVariable int customerId) {
        this.customerService.updateCustomerById(customer,customerId);

    }

    @GetMapping("/getOneCustomer/{customerId}")
    public Customer getOneCustomer(@PathVariable int customerId){
        return customerService.getOneCustomer(customerId);
    }















}
