package ua.dragunovskiy.apartment_rental_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_rest_api.dao.*;
import ua.dragunovskiy.apartment_rental_rest_api.entity.*;

import java.util.List;


@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    private Dao<Long, Apartment> apartmentDao;

    @GetMapping("/")
    public List<Apartment> getAllApartments() {
        return apartmentDao.getAll();
    }

    @GetMapping("/{id}")
    public Apartment getApartmentById(@PathVariable("id") Long id) {
       return apartmentDao.getById(id);
    }

    @PostMapping("/add")
    public void addNewApartment(@RequestBody Apartment apartment) {
        apartmentDao.add(apartment);
    }

    @PutMapping("/update/{apartmentId}")
    public void updateApartment(@PathVariable("apartmentId") Long apartmentId, @RequestBody Apartment apartment) {
        apartmentDao.update(apartmentId, apartment);
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable("id") Long id) {
        apartmentDao.delete(id);
    }
}
