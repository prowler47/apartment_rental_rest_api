package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Hospital;

import java.util.List;

@Service
public class HospitalServiceImpl implements InfoService<Long, Hospital> {

    @Autowired
    private InfoDao<Long, Hospital> hospitalInfoDao;

    @Override
    public List<Hospital> getAll(Long id) {
        return hospitalInfoDao.getAll(id);
    }

    @Override
    public void add(Long apartmentId, Hospital entity) {
        hospitalInfoDao.add(apartmentId, entity);
    }

    @Override
    public void delete(Long apartmentId, Long infoStructId) {
        hospitalInfoDao.delete(apartmentId, infoStructId);
    }

    @Override
    public void update(Long apartmentId, Long infoId, Hospital entity) {
        hospitalInfoDao.update(apartmentId, infoId, entity);
    }
}
