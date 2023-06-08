package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;

@RestController
@RequestMapping("/info/update/")
public class InfoStructUpdateController {

    @Autowired
    private InfoDao<Long, EducationEstablishment> establishmentsDao;

    @Autowired
    private InfoDao<Long, Hospital> hospitalDao;

    @Autowired
    private InfoDao<Long, Parking> parkingInfoDao;

    @Autowired
    private InfoDao<Long, RoadJunction> roadJunctionInfoDao;

    @Autowired
    private InfoDao<Long, Store> storeInfoDao;


    @PutMapping("/educ/{apartmentId}/{educId}")
    public void updateEducationEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("educId") Long educId,
                                             @RequestBody EducationEstablishment educationEstablishment) {
        establishmentsDao.update(apartmentId, educId, educationEstablishment);
    }

    @PutMapping("/hospital/{apartmentId}/{hospitalId}")
    public void updateHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("hospitalId") Long hospitalId,
                               @RequestBody Hospital hospital) {
        hospitalDao.update(apartmentId, hospitalId, hospital);
    }

    @PutMapping("/parking/{apartmentId}/{parkingId}")
    public void updateParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("parkingId") Long parkingId,
                              @RequestBody Parking parking) {
        parkingInfoDao.update(apartmentId, parkingId, parking);
    }

    @PutMapping("/roadJunction/{apartmentId}/{roadJunctionId}")
    public void updateRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("roadJunctionId") Long roadJunctionId,
                                   @RequestBody RoadJunction roadJunction) {
        roadJunctionInfoDao.update(apartmentId, roadJunctionId, roadJunction);
    }

    @PutMapping("/store/{apartmentId}/{storeId}")
    public void updateStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("storeId") Long storeId,
                            @RequestBody Store store) {
        storeInfoDao.update(apartmentId, storeId, store);
    }
}
