package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.RoadJunction;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Store;

import java.util.Collections;
import java.util.List;

@Repository
public class RoadJunctionDaoImpl implements InfoDao<Long, RoadJunction> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<RoadJunction> getAll(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
           return apartment.getApartmentInfoStruct().getRoadJunctionList();
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void add(Long apartmentId, RoadJunction roadJunction) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            roadJunction.setApartmentInfoStructRoadJunction(apartment.getApartmentInfoStruct());
            roadJunction.getApartmentInfoStructRoadJunction().setId(apartmentId);
            apartment.getApartmentInfoStruct().getRoadJunctionList().add(roadJunction);
            session.persist(roadJunction);
        }
    }

    @Override
    @Transactional
    public void delete(Long apartmentId, Long infoStructId) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            List<RoadJunction> roadJunctionList = apartment.getApartmentInfoStruct().getRoadJunctionList();
            RoadJunction roadJunctionForDelete = roadJunctionList.stream()
                    .filter(e -> e.getId() == infoStructId)
                    .findFirst()
                    .orElse(null);

            if (roadJunctionForDelete != null) {
                apartment.getApartmentInfoStruct().getRoadJunctionList().remove(roadJunctionForDelete);
                session.remove(roadJunctionForDelete);
            }
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Long infoId, RoadJunction roadJunctionForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            RoadJunction roadJunctionToUpdate = apartment.getApartmentInfoStruct().getRoadJunctionList().stream()
                    .filter(e -> e.getId() == infoId)
                    .findFirst()
                    .orElse(null);
            if (roadJunctionToUpdate != null) {
                roadJunctionToUpdate.setName(roadJunctionForUpdate.getName());
                roadJunctionToUpdate.setTime(roadJunctionForUpdate.getTime());
                session.merge(roadJunctionToUpdate);
            }
        }
    }
}
