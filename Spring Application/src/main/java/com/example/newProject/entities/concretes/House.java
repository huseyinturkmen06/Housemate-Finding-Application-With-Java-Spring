package com.example.newProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    //1 ev 1den çok ev sahibine sahip olabilir
    @OneToMany()
    @JoinColumn(name="owner_id")
    private List<HouseOwner> ownerId;

    //sanırım bu kolona birden fazla ec sahibi gelebileceği için
    //liste içine almamız gerekti
    //house u ownerId den bulma








}
