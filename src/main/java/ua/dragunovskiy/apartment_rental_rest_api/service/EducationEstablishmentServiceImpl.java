package ua.dragunovskiy.apartment_rental_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragunovskiy.apartment_rental_rest_api.dao.InfoDao;
import ua.dragunovskiy.apartment_rental_rest_api.entity.EducationEstablishment;

import java.util.List;

@Service
public class EducationEstablishmentServiceImpl implements InfoService<Long, EducationEstablishment> {

    @Autowired
    private InfoDao<Long, EducationEstablishment> establishmentInfoDao;

    @Override
    public List<EducationEstablishment> getAll(Long id) {
        return establishmentInfoDao.getAll(id);
    }

    @Override
    public void add(Long apartmentId, EducationEstablishment entity) {
        establishmentInfoDao.add(apartmentId, entity);
    }

    @Override
    public void delete(Long apartmentId, Long infoStructId) {
        establishmentInfoDao.delete(apartmentId, infoStructId);
    }

    @Override
    public void update(Long apartmentId, Long infoId, EducationEstablishment entity) {
        establishmentInfoDao.update(apartmentId, infoId, entity);
    }
}
