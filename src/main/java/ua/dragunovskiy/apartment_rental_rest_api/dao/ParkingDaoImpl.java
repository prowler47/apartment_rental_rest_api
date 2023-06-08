package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.ApartmentInfoStruct;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Hospital;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Parking;

import java.util.Collections;
import java.util.List;

@Repository
public class ParkingDaoImpl implements InfoDao<Long, Parking> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Parking> getAll(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            ApartmentInfoStruct apartmentInfoStruct = apartment.getApartmentInfoStruct();
            return apartmentInfoStruct.getParkingList();
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void add(Long apartmentId, Parking parking) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            parking.setApartmentInfoStructParking(apartment.getApartmentInfoStruct());
            parking.getApartmentInfoStructParking().setId(apartmentId);
            apartment.getApartmentInfoStruct().getParkingList().add(parking);
            session.persist(parking);
        }
    }

    @Override
    @Transactional
    public void delete(Long apartmentId, Long infoStructId) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            List<Parking> parkingList = apartment.getApartmentInfoStruct().getParkingList();
            Parking parkingForDelete = parkingList.stream()
                    .filter(e -> e.getId() == infoStructId)
                    .findFirst()
                    .orElse(null);
            if (parkingForDelete != null) {
                apartment.getApartmentInfoStruct().getParkingList().remove(parkingForDelete);
                session.remove(parkingForDelete);
            }
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Long infoId, Parking parkingForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            Parking parkingToUpdate = apartment.getApartmentInfoStruct().getParkingList().stream()
                    .filter(e -> e.getId() == infoId)
                    .findFirst()
                    .orElse(null);
            if (parkingToUpdate != null) {
                parkingToUpdate.setName(parkingForUpdate.getName());
                parkingToUpdate.setTime(parkingForUpdate.getTime());
                session.merge(parkingToUpdate);
            }
        }
    }
}
