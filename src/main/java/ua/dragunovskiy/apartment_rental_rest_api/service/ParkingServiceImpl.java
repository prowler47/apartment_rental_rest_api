package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Parking;

import java.util.List;

@Service
public class ParkingServiceImpl implements InfoService<Long, Parking> {

    @Autowired
    private InfoDao<Long, Parking> parkingInfoDao;

    @Override
    public List<Parking> getAll(Long id) {
        return parkingInfoDao.getAll(id);
    }

    @Override
    public void add(Long apartmentId, Parking entity) {
        parkingInfoDao.add(apartmentId, entity);
    }

    @Override
    public void delete(Long apartmentId, Long infoStructId) {
        parkingInfoDao.delete(apartmentId, infoStructId);
    }

    @Override
    public void update(Long apartmentId, Long infoId, Parking entity) {
        parkingInfoDao.update(apartmentId, infoId, entity);
    }
}
