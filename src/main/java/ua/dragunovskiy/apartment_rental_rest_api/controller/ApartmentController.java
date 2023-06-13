package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;
import ua.dragunovskiy.apartment_rental_rest_api.service.Service;

import java.util.List;


@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    private Service<Long, Apartment> apartmentService;

    @GetMapping("/")
    public List<Apartment> getAllApartments() {
        return apartmentService.getAll();
    }

    @GetMapping("/{id}")
    public Apartment getApartmentById(@PathVariable("id") Long id) {
        return apartmentService.getById(id);
    }

    @GetMapping("/byName/{address}")
    public List<Apartment> getApartmentByAddress(@PathVariable("address") String address) {
        return apartmentService.getByAddress(address);
    }

    @GetMapping("/byContainsName/{address}")
    public List<Apartment> getApartmentByContainsAddress(@PathVariable("address") String address) {
        return apartmentService.getByContainsAddress(address);
    }

    @PostMapping("/add")
    public void addNewApartment(@RequestBody Apartment apartment) {
        apartmentService.add(apartment);
    }

    @PutMapping("/update/{apartmentId}")
    public void updateApartment(@PathVariable("apartmentId") Long apartmentId, @RequestBody Apartment apartment) {
        apartmentService.update(apartmentId, apartment);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable("id") Long id) {
        apartmentService.delete(id);
    }
}
