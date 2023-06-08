package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;

import java.util.List;

@RestController
@RequestMapping("/info/get/")
public class InfoStructGetController {
    @Autowired
    private InfoDao<Long, Parking> parkingDao;

    @Autowired
    private InfoDao<Long, EducationEstablishment> educDao;

    @Autowired
    private InfoDao<Long, Hospital> hospitalDao;

    @Autowired
    private InfoDao<Long, RoadJunction> roadJunctionDao;

    @Autowired
    private InfoDao<Long, Store> storeDao;

    @GetMapping("/parkingList/{id}")
    public List<Parking> getAllParking(@PathVariable("id") Long id) {
        return parkingDao.getAll(id);
    }

    @GetMapping("/educList/{id}")
    public List<EducationEstablishment> getAllEduc(@PathVariable("id") Long id) {
        return educDao.getAll(id);
    }

    @GetMapping("/hospitalsList/{id}")
    public List<Hospital> getAllHospitals(@PathVariable("id") Long id) {
        return hospitalDao.getAll(id);
    }

    @GetMapping("/roadJunctionsList/{id}")
    public List<RoadJunction> getAllRoadJunctions(@PathVariable("id") Long id) {
        return roadJunctionDao.getAll(id);
    }

    @GetMapping("/storesList/{id}")
    public List<Store> getAllStores(@PathVariable("id") Long id) {
        return storeDao.getAll(id);
    }
}
