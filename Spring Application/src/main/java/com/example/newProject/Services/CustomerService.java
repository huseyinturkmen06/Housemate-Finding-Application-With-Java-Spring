package com.example.newProject.Services;


import com.example.newProject.DTOs.Requests.CustomerSaveRequest;
import com.example.newProject.Entities.House;
import com.example.newProject.Repositories.CustomerRepository;
import com.example.newProject.Entities.Customer;
import com.example.newProject.Repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    HouseRepository houseRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,HouseRepository houseRepository) {
        this.customerRepository = customerRepository;
        this.houseRepository=houseRepository;
    }



    //getAll
    public List<Customer> getall() {
        return this.customerRepository.findAll();
    }


    //getOneCustomerById
    public Customer getOneCustomerById(int customerId){
        return customerRepository.findById(customerId).orElse(null);
    }


    //save
//    public void saveOneCustomer(CustomerSaveRequest customerSaveRequest) {
////        this.customerRepository.save(customer);
//        //customerı alırken id almak istemeyiz
//        //id kendi kenkndine artsın, dışarıdan verilemesin ve
//        //veermekle de uğraşılmasın
//
//
//        House house=houseRepository.getByHouseId(customerSaveRequest.getHouseId());
//        if(house==null){
//            System.out.println("böyle bir ev yok");
//        }
//        else{
//            Customer customer=new Customer();
//            //id değeri zaten kendinden aouto incerement olarak gelecek, bizim yeniden vermemize gerek yok
//            customer.setCustomerId(customerSaveRequest.getCustomerId());
//            customer.setCustomerName(customerSaveRequest.getCustomerName());
//            customer.setCustomerSurname(customerSaveRequest.getCustomerSurname());
//            customer.setCustomerAge(customerSaveRequest.getCustomerAge());
//            customer.setCustomerHometown(customerSaveRequest.getCustomerHometown());
//            customer.setCustomerDepartment(customerSaveRequest.getCustomerDepartment());
//            customer.setCustomerGrade(customerSaveRequest.getCustomerGrade());
//            customer.setCustomerPhone(customerSaveRequest.getCustomerPhone());
//            customer.setCustomerEmail(customerSaveRequest.getCustomerEmail());
//            customer.setHouse(house);
//
//            customerRepository.save(customer);
//        }
//
//
//
//    }




    //update
    public void updateCustomerById(Customer customer,int customerId) {
        Optional<Customer> customerTemp= customerRepository.findById(customerId);
        if(customerTemp.isPresent()){
            this.customerRepository.save(customer);
            //varsa güncelle
        }
        else {
            //yoksa güncelleme
            System.out.println("bu id ye sahip kullanıcı bulunmamaktadır" +
                    "isterseniz aynı isteği get ile yapabilirsiniz");

        }

        //2. bir yazılış da
        //Customer customerTemp=customerDao.findById(customerId).orElse(null);
        //if(customerTemp!=null){

    }

    public void saveOneCustomer2(Customer customer) {
        customerRepository.save(customer);
    }


    public Customer getOneCustomer(int customerId){
        return customerRepository.findById(customerId).orElse(null);
    }


}
