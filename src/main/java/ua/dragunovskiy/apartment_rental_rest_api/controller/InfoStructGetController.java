package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;
import ua.dragunovskiy.apartment_rental_rest_api.service.InfoService;

import java.util.List;

@RestController
@RequestMapping("/info/get/")
public class InfoStructGetController {

    @Autowired
    private InfoService<Long, Parking> parkingInfoService;

    @Autowired
    private InfoService<Long, EducationEstablishment> educationEstablishmentInfoService;

    @Autowired
    private InfoService<Long, Hospital> hospitalInfoService;

    @Autowired
    private InfoService<Long, RoadJunction> roadJunctionInfoService;

    @Autowired
    private InfoService<Long, Store> storeInfoService;

    @GetMapping("/parkingList/{id}")
    public List<Parking> getAllParking(@PathVariable("id") Long id) {
        return parkingInfoService.getAll(id);
    }

    @GetMapping("/educList/{id}")
    public List<EducationEstablishment> getAllEduc(@PathVariable("id") Long id) {
        return educationEstablishmentInfoService.getAll(id);
    }

    @GetMapping("/hospitalsList/{id}")
    public List<Hospital> getAllHospitals(@PathVariable("id") Long id) {
        return hospitalInfoService.getAll(id);
    }

    @GetMapping("/roadJunctionsList/{id}")
    public List<RoadJunction> getAllRoadJunctions(@PathVariable("id") Long id) {
        return roadJunctionInfoService.getAll(id);
    }

    @GetMapping("/storesList/{id}")
    public List<Store> getAllStores(@PathVariable("id") Long id) {
        return storeInfoService.getAll(id);
    }
}
