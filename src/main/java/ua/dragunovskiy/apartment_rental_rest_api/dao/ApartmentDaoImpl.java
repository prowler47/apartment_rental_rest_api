package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.ApartmentInfoStruct;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ApartmentDaoImpl implements Dao<Long, Apartment> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Apartment> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Apartment> query = session.createQuery("from Apartment", Apartment.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Apartment getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Apartment.class, id);
    }

    @Override
    @Transactional
    public List<Apartment> getByAddress(String address) {
        Session session = entityManager.unwrap(Session.class);
        String selectByName = "from Apartment where address = :address";
        Query<Apartment> query = session.createQuery(selectByName, Apartment.class);
        query.setParameter("address", address);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Apartment> getByContainsAddress(String address) {
        Session session = entityManager.unwrap(Session.class);
        Query<Apartment> query = session.createQuery("from Apartment", Apartment.class);
        List<Apartment> apartmentList = query.getResultList();
        return apartmentList.stream()
                .filter(e -> e.getAddress().startsWith(address))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void add(Apartment entity) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(entity);
        ApartmentInfoStruct apartmentInfoStruct = new ApartmentInfoStruct();
        apartmentInfoStruct.setId(entity.getId());
        apartmentInfoStruct.setApartment(entity);
        apartmentInfoStruct.setEducId(entity.getId());
        apartmentInfoStruct.setHospitalId(entity.getId());
        apartmentInfoStruct.setParkingId(entity.getId());
        apartmentInfoStruct.setRoad_junction_id(entity.getId());
        apartmentInfoStruct.setStoreId(entity.getId());
        session.persist(apartmentInfoStruct);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null) {
            ApartmentInfoStruct apartmentInfoStruct = apartment.getApartmentInfoStruct();
            List<Hospital> hospitalList = apartmentInfoStruct.getHospitalList();
            for (Hospital hospital : hospitalList) {
                hospital.setApartmentInfoStructHospitals(null);
                session.merge(hospital);
            }
            apartment.setApartmentInfoStruct(null);
            session.remove(apartmentInfoStruct);
            session.remove(apartment);
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Apartment apartmentForUpdate) {
        Apartment apartmentToUpdate = getById(apartmentId);
        apartmentToUpdate.setAddress(apartmentForUpdate.getAddress());
        apartmentToUpdate.setCity(apartmentForUpdate.getCity());
        apartmentToUpdate.setPrice(apartmentForUpdate.getPrice());
        apartmentToUpdate.setPetFriendly(apartmentForUpdate.isPetFriendly());
        Session session = entityManager.unwrap(Session.class);
        session.merge(apartmentToUpdate);
    }
}
