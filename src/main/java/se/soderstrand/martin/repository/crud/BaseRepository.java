package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.entity.AbstractEntity;
import se.soderstrand.martin.exception.RepositoryException;

import javax.persistence.*;
import java.util.List;

public abstract class BaseRepository<T extends AbstractEntity> implements CrudRepository<T> {
    private final EntityManagerFactory FACTORY;
    private final Class<T> entityClass;

    protected BaseRepository(Class<T> entityClass, EntityManagerFactory factory) {
        this.entityClass = entityClass;
        this.FACTORY = factory;
    }

    @Override
    public T saveOrUpdate(T entity) throws RepositoryException {
        return null;
    }

    @Override
    public T findById(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public void delete(T t) throws RepositoryException {

    }
}
