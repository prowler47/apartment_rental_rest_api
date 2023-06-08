package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.EducationEstablishment;

import java.util.Collections;
import java.util.List;

@Repository
public class EducationEstablishmentsDaoImpl implements InfoDao<Long, EducationEstablishment> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<EducationEstablishment> getAll(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            return  apartment.getApartmentInfoStruct().getEducationEstablishmentList();
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void add(Long apartmentId, EducationEstablishment educationEstablishment) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            educationEstablishment.setApartmentInfoStructEduc(apartment.getApartmentInfoStruct());
            apartment.getApartmentInfoStruct().getEducationEstablishmentList().add(educationEstablishment);
            session.merge(educationEstablishment);
        }
    }

    @Override
    @Transactional
    public void delete(Long apartmentId, Long infoStructId) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            List<EducationEstablishment> educationEstablishmentList = apartment.getApartmentInfoStruct().getEducationEstablishmentList();
            EducationEstablishment educForDelete = educationEstablishmentList.stream()
                    .filter(e -> e.getId() == infoStructId)
                    .findFirst()
                    .orElse(null);

            if (educForDelete != null) {
                apartment.getApartmentInfoStruct().getEducationEstablishmentList().remove(educForDelete);
                session.remove(educForDelete);
            }
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Long infoId, EducationEstablishment educationEstablishmentForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            EducationEstablishment educationEstablishmentToUpdate = apartment.getApartmentInfoStruct().getEducationEstablishmentList().stream()
                    .filter(e -> e.getId() == infoId)
                    .findFirst()
                    .orElse(null);

            if (educationEstablishmentToUpdate != null) {
                educationEstablishmentToUpdate.setName(educationEstablishmentForUpdate.getName());
                educationEstablishmentToUpdate.setTime(educationEstablishmentForUpdate.getTime());
                session.merge(educationEstablishmentToUpdate);
            }
        }
    }
}
