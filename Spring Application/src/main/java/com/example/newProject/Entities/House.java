package com.example.newProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="houses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ownerId"})

public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="house_id")
    private int houseId;

    @Column(name="house_address    ")
    private String houseAddress    ;

    @Column(name="count_of_bathroom")
    private int countOfBathroom;

    @Column(name="count_of_bedroom")
    private int countOfBedroom;

    @Column(name="count_of_salon")
    private int countOfSalon;

    @Column(name="count_of_owner")
    private int countOfOwner;

    @Column(name="heat_resource")
    private String heatResource;

    @Column(name="furnished")
    private String furnished;

    @Column(name="internet_paved")
    private String internetPaved;

    @Column(name="floor")
    private int floor;

    @Column(name="rent")
    private int rent;

//    @Column(name="owner_id   ")
//    private int ownerId   ;


    @Nullable
    //1 ev 1den çok ev sahibine sahip olabilir
    @OneToMany()
    @JoinColumn(name="owner_id")
    @JsonIgnore
    //bu sayede house çağırırken
    //bağlı olunan owners listesi de gelip karışık görünmeyecek
    private List<HouseOwner> ownerId;

    @Nullable
    @OneToMany()
    @JoinColumn(name="customer_id")
    @JsonIgnore
    //bu sayede house çağırırken
    //bağlı olunan customers listesi de gelip karışık görünmeyecek
    private List<Customer> customerId;










}
