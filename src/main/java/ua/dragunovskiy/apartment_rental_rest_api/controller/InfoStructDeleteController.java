package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;
import ua.dragunovskiy.apartment_rental_rest_api.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoStructDeleteController {

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

    @RequestMapping("/delete/educ/{apartmentId}/{infoStructId}")
    public void deleteEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoStructId") Long infoStructId) {
        educationEstablishmentInfoService.delete(apartmentId, infoStructId);
    }

    @RequestMapping("/delete/hospital/{apartmentId}/{infoStructId}")
    public void deleteHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoStructId") Long infoStructId) {
        hospitalInfoService.delete(apartmentId, infoStructId);
    }

    @RequestMapping("/delete/parking/{apartmentId}/{infoStructId}")
    public void deleteParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoStructId") Long infoStructId) {
        parkingInfoService.delete(apartmentId, infoStructId);
    }

    @RequestMapping("/delete/roadJunction/{apartmentId}/{infoStructId}")
    public void deleteRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoStructId") Long infoStructId) {
        roadJunctionInfoService.delete(apartmentId, infoStructId);
    }

    @RequestMapping("/delete/store/{apartmentId}/{infoStructId}")
    public void deleteStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoStructId") Long infoStructId) {
        storeInfoService.delete(apartmentId, infoStructId);
    }
}
