package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.dragunovskiy.apartment_rental_rest_api.dao.Dao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;

import java.util.List;

@org.springframework.stereotype.Service
public class ApartmentServiceImpl implements Service<Long, Apartment> {

    @Autowired
    private Dao<Long, Apartment> apartmentDao;

    @Override
    public List<Apartment> getAll() {
        return apartmentDao.getAll();
    }

    @Override
    public Apartment getById(Long id) {
        return apartmentDao.getById(id);
    }

    @Override
    public List<Apartment> getByAddress(String address) {
        return apartmentDao.getByAddress(address);
    }

    @Override
    public List<Apartment> getByContainsAddress(String address) {
       return apartmentDao.getByContainsAddress(address);
    }

    @Override
    public void add(Apartment entity) {
        apartmentDao.add(entity);
    }

    @Override
    public void delete(Long id) {
        apartmentDao.delete(id);
    }

    @Override
    public void update(Long id, Apartment entityForUpdate) {
        apartmentDao.update(id, entityForUpdate);
    }
}
