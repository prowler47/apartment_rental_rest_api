package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Hospital;

import java.util.Collections;
import java.util.List;

@Repository
public class HospitalDaoImpl implements InfoDao<Long, Hospital> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Hospital> getAll(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            return apartment.getApartmentInfoStruct().getHospitalList();
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void add(Long apartmentId, Hospital hospital) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            hospital.setApartmentInfoStructHospitals(apartment.getApartmentInfoStruct());
            hospital.getApartmentInfoStructHospitals().setId(apartmentId);
            apartment.getApartmentInfoStruct().getHospitalList().add(hospital);
            session.persist(hospital);
        }
    }

    @Override
    @Transactional
    public void delete(Long apartmentId, Long infoStructId) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            List<Hospital> hospitalList = apartment.getApartmentInfoStruct().getHospitalList();
            Hospital hospitalForDelete = hospitalList.stream()
                    .filter(e -> e.getId() == infoStructId)
                    .findFirst()
                    .orElse(null);

            if (hospitalForDelete != null) {
                apartment.getApartmentInfoStruct().getHospitalList().remove(hospitalForDelete);
                session.remove(hospitalForDelete);
            }
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Long infoId, Hospital hospitalForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            Hospital hospitalToUpdate = apartment.getApartmentInfoStruct().getHospitalList().stream()
                    .filter(e -> e.getId() == infoId)
                    .findFirst()
                    .orElse(null);

            if (hospitalToUpdate != null) {
                hospitalToUpdate.setName(hospitalForUpdate.getName());
                hospitalToUpdate.setTime(hospitalForUpdate.getTime());
                session.merge(hospitalToUpdate);
            }
        }
    }

}
