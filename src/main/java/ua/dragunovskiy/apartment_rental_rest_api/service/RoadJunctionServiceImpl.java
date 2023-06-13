package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.RoadJunction;

import java.util.List;

@Service
public class RoadJunctionServiceImpl implements InfoService<Long, RoadJunction> {

    @Autowired
    private InfoDao<Long, RoadJunction> roadJunctionInfoDao;

    @Override
    public List<RoadJunction> getAll(Long id) {
        return roadJunctionInfoDao.getAll(id);
    }

    @Override
    public void add(Long apartmentId, RoadJunction entity) {
        roadJunctionInfoDao.add(apartmentId, entity);
    }

    @Override
    public void delete(Long apartmentId, Long infoStructId) {
        roadJunctionInfoDao.delete(apartmentId, infoStructId);
    }

    @Override
    public void update(Long apartmentId, Long infoId, RoadJunction entity) {
        roadJunctionInfoDao.update(apartmentId, infoId, entity);
    }
}
