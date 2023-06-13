package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;
import ua.dragunovskiy.apartment_rental_rest_api.service.InfoService;

@RestController
@RequestMapping("/info/add/")
public class InfoStructAddController {

    @Autowired
    private InfoService<Long, EducationEstablishment> educationEstablishmentInfoService;

    @Autowired
    private InfoService<Long, Hospital> hospitalInfoService;

    @Autowired
    private InfoService<Long, Parking> parkingInfoService;

    @Autowired
    private InfoService<Long, RoadJunction> roadJunctionInfoService;

    @Autowired
    private InfoService<Long, Store> storeInfoService;

    @PostMapping("/educ/{apartmentId}")
    public void addNewEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @RequestBody EducationEstablishment educationEstablishment) {
        educationEstablishmentInfoService.add(apartmentId, educationEstablishment);
    }

    @PostMapping("/hospital/{apartmentId}")
    public void addNewHospital(@PathVariable("apartmentId") Long apartmentId, @RequestBody Hospital hospital) {
        hospitalInfoService.add(apartmentId, hospital);
    }

    @PostMapping("/parking/{apartmentId}")
    public void addNewParking(@PathVariable("apartmentId") Long apartmentId, @RequestBody Parking parking) {
        parkingInfoService.add(apartmentId, parking);
    }

    @PostMapping("/roadJunction/{apartmentId}")
    public void addNewRoadJunction(@PathVariable("apartmentId") Long apartmentId, @RequestBody RoadJunction roadJunction) {
        roadJunctionInfoService.add(apartmentId, roadJunction);
    }

    @PostMapping("/store/{apartmentId}")
    public void addNewStore(@PathVariable("apartmentId") Long apartmentId, @RequestBody Store store) {
        storeInfoService.add(apartmentId, store);
    }
}
