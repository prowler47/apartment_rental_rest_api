package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;

@RestController
@RequestMapping("/info/add/")
public class InfoStructAddController {

    @Autowired
    private InfoDao<Long, EducationEstablishment> establishmentsDao;

    @Autowired
    private InfoDao<Long, Hospital> hospitalDao;

    @Autowired
    private InfoDao<Long, Parking> parkingDao;

    @Autowired
    private InfoDao<Long, RoadJunction> roadJunctionDao;

    @Autowired
    private InfoDao<Long, Store> storeDao;

    @PostMapping("/educ/{apartmentId}")
    public void addNewEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @RequestBody EducationEstablishment educationEstablishment) {
        establishmentsDao.add(apartmentId, educationEstablishment);
    }

    @PostMapping("/hospital/{apartmentId}")
    public void addNewHospital(@PathVariable("apartmentId") Long apartmentId, @RequestBody Hospital hospital) {
        hospitalDao.add(apartmentId, hospital);
    }

    @PostMapping("/parking/{apartmentId}")
    public void addNewParking(@PathVariable("apartmentId") Long apartmentId, @RequestBody Parking parking) {
        parkingDao.add(apartmentId, parking);
    }

    @PostMapping("/roadJunction/{apartmentId}")
    public void addNewRoadJunction(@PathVariable("apartmentId") Long apartmentId, @RequestBody RoadJunction roadJunction) {
        roadJunctionDao.add(apartmentId, roadJunction);
    }

    @PostMapping("/store/{apartmentId}")
    public void addNewStore(@PathVariable("apartmentId") Long apartmentId, @RequestBody Store store) {
        storeDao.add(apartmentId, store);
    }

}
