package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.entity.AbstractEntity;
import se.soderstrand.martin.exception.RepositoryException;

import java.util.List;

public interface CrudRepository<T extends AbstractEntity> {

    T saveOrUpdate(T entity) throws RepositoryException;

    T findById(Long id) throws RepositoryException;

    void delete(T t) throws RepositoryException;
}
