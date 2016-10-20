package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.exception.RepositoryException;

import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public interface CrudRepository<T> {

    void create(T t) throws RepositoryException;

    T read(Long id) throws RepositoryException;

    void update(T t) throws RepositoryException;

    void changeStatus(T t) throws RepositoryException;

    List<T> getAll(Class type) throws RepositoryException;
}
