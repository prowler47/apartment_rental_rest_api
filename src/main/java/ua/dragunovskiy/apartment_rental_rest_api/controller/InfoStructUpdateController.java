package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;
import ua.dragunovskiy.apartment_rental_rest_api.service.InfoService;

import javax.sound.sampled.AudioFileFormat;

@RestController
@RequestMapping("/info/update/")
public class InfoStructUpdateController {

    @Autowired
    private InfoService<Long, EducationEstablishment> educationEstablishmentInfoService;

    @Autowired
    private InfoService<Long, Hospital> hospitalInfoService;

    @Autowired
    private InfoService<Long, Parking> parkingInfoService;

    @Autowired
    private InfoDao<Long, RoadJunction> roadJunctionInfoDao;

    @Autowired
    private InfoService<Long, Store> storeInfoService;


    @PutMapping("/educ/{apartmentId}/{educId}")
    public void updateEducationEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("educId") Long educId,
                                             @RequestBody EducationEstablishment educationEstablishment) {
        educationEstablishmentInfoService.update(apartmentId, educId, educationEstablishment);
    }

    @PutMapping("/hospital/{apartmentId}/{hospitalId}")
    public void updateHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("hospitalId") Long hospitalId,
                               @RequestBody Hospital hospital) {
        hospitalInfoService.update(apartmentId, hospitalId, hospital);
    }

    @PutMapping("/parking/{apartmentId}/{parkingId}")
    public void updateParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("parkingId") Long parkingId,
                              @RequestBody Parking parking) {
        parkingInfoService.update(apartmentId, parkingId, parking);
    }

    @PutMapping("/roadJunction/{apartmentId}/{roadJunctionId}")
    public void updateRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("roadJunctionId") Long roadJunctionId,
                                   @RequestBody RoadJunction roadJunction) {
        roadJunctionInfoDao.update(apartmentId, roadJunctionId, roadJunction);
    }

    @PutMapping("/store/{apartmentId}/{storeId}")
    public void updateStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("storeId") Long storeId,
                            @RequestBody Store store) {
        storeInfoService.update(apartmentId, storeId, store);
    }
}
