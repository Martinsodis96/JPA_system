package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.exception.RepositoryException;

import java.util.List;

public interface CrudRepository<T> {

    void create(T t) throws RepositoryException;

    T read(Long id, Class<T> type) throws RepositoryException;

    void update(T t) throws RepositoryException;

    void delete(T t) throws RepositoryException;

    List<T> getAll(Class<T> type) throws RepositoryException;
}
