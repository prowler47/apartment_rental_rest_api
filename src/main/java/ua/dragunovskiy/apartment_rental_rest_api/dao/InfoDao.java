package ua.dragunovskiy.apartment_rental_rest_api.dao;

import java.util.List;

public interface InfoDao <T, E> {
    List<E> getAll(T id);
    void add(T apartmentId, E entity);
    void delete(T apartmentId, T infoStructId);
    void update(T apartmentId, T infoId, E entity);
}
