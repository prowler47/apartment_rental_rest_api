package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Store;

import java.util.List;

@Service
public class StoreServiceImpl implements InfoService<Long, Store> {

    @Autowired
    private InfoDao<Long, Store> storeInfoDao;

    @Override
    public List<Store> getAll(Long id) {
        return storeInfoDao.getAll(id);
    }

    @Override
    public void add(Long apartmentId, Store entity) {
        storeInfoDao.add(apartmentId, entity);
    }

    @Override
    public void delete(Long apartmentId, Long infoStructId) {
        storeInfoDao.delete(apartmentId, infoStructId);
    }

    @Override
    public void update(Long apartmentId, Long infoId, Store entity) {
        storeInfoDao.update(apartmentId, infoId, entity);
    }
}
