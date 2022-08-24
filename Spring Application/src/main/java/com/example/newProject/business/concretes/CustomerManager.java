package com.example.newProject.business.concretes;


import com.example.newProject.business.abstarcts.CustomerService;
import com.example.newProject.dataAccess.abstracts.CustomerDao;
import com.example.newProject.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public List<Customer> getall() {
        return this.customerDao.findAll();
    }

    @Override
    public Customer add(Customer customer) {
        this.customerDao.save(customer);
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        this.customerDao.save(customer);
        return null;
    }




}
