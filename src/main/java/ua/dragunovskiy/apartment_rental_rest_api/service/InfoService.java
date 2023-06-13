package ua.dragunovskiy.apartment_rental_rest_api.service;

import java.util.List;

public interface InfoService<T, E> {
    List<E> getAll(T id);
    void add(T apartmentId, E entity);
    void delete(T apartmentId, T infoStructId);
    void update(T apartmentId, T infoId, E entity);
}
