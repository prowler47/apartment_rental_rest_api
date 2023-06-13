package ua.dragunovskiy.apartment_rental_rest_api.service;

import java.util.List;

public interface Service<T, E> {
    List<E> getAll();
    E getById(Long id);
    List<E> getByAddress(String address);
    List<E> getByContainsAddress(String address);
    void add(E entity);
    void delete(Long id);
    void update(T id, E entityForUpdate);
}
