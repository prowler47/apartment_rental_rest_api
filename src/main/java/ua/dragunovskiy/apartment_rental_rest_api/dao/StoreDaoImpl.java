package ua.dragunovskiy.apartment_rental_rest_api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Apartment;
import ua.dragunovskiy.apartment_rental_rest_api.entity.Store;

import java.util.Collections;
import java.util.List;

@Repository
public class StoreDaoImpl implements InfoDao<Long, Store> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Store> getAll(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, id);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            return apartment.getApartmentInfoStruct().getStoreList();
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void add(Long apartmentId, Store store) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            store.setApartmentInfoStructStore(apartment.getApartmentInfoStruct());
            apartment.getApartmentInfoStruct().getStoreList().add(store);
            session.persist(store);
        }
    }

    @Override
    @Transactional
    public void delete(Long apartmentId, Long infoStructId) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            List<Store> storeList = apartment.getApartmentInfoStruct().getStoreList();
            Store storeForDelete = storeList.stream()
                    .filter(e -> e.getId() == infoStructId)
                    .findFirst()
                    .orElse(null);

            if (storeForDelete != null) {
                apartment.getApartmentInfoStruct().getStoreList().remove(storeForDelete);
                session.remove(storeForDelete);
            }
        }
    }

    @Override
    @Transactional
    public void update(Long apartmentId, Long infoId, Store storeForUpdate) {
        Session session = entityManager.unwrap(Session.class);
        Apartment apartment = session.get(Apartment.class, apartmentId);
        if (apartment != null && apartment.getApartmentInfoStruct() != null) {
            Store storeToUpdate = apartment.getApartmentInfoStruct().getStoreList().stream()
                    .filter(e -> e.getId() == infoId)
                    .findFirst()
                    .orElse(null);
            if (storeToUpdate != null) {
                storeToUpdate.setName(storeForUpdate.getName());
                storeToUpdate.setTime(storeForUpdate.getTime());
                session.merge(storeToUpdate);
            }
        }
    }
}
