package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.entity.AbstractEntity;
import se.soderstrand.martin.exception.RepositoryException;

import javax.persistence.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseRepository<T extends AbstractEntity> implements CrudRepository<T> {
    private final EntityManagerFactory FACTORY;
    private final Class<T> entityClass;

    protected BaseRepository(Class<T> entityClass, EntityManagerFactory FACTORY) {
        this.entityClass = entityClass;
        this.FACTORY = FACTORY;
    }

    @Override
    public T saveOrUpdate(T entity) throws RepositoryException {
        return entity.getId() == null ? execute(manager -> {
            manager.persist(entity);
            return entity;
        }) : execute(manager -> manager.merge(entity));
    }

    @Override
    public T findById(Long id) throws RepositoryException {
        EntityManager manager = FACTORY.createEntityManager();
        try {
            return manager.find(entityClass, id);
        }finally {
            manager.close();
        }
    }

    @Override
    public T delete(T t) throws RepositoryException {
        return execute(manager -> {
            T entityToRemove = manager.find(entityClass, t.getId());
            manager.remove(entityToRemove);
            return entityToRemove;
        });
    }

    protected T querySingle(String queryName, Function<TypedQuery<T>, TypedQuery<T>> query) {
        List<T> result = query(queryName, query);
        return result == null ? null : result.get(0);
    }

    protected List<T> query(String queryName, Function<TypedQuery<T>, TypedQuery<T>> query) {
        EntityManager manager = FACTORY.createEntityManager();
        try {
            TypedQuery<T> typedQuery = manager.createNamedQuery(queryName, entityClass);
            return query.apply(typedQuery).getResultList();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            manager.close();
        }
    }

    protected T execute(Function<EntityManager, T> operation) {
        EntityManager manager = FACTORY.createEntityManager();
        try {
            manager.getTransaction().begin();
            T result = operation.apply(manager);
            manager.getTransaction().commit();

            return result;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            manager.close();
        }
    }

    protected void executeVoid(Consumer<EntityManager> operation) {
        EntityManager manager = FACTORY.createEntityManager();
        try {
            manager.getTransaction().begin();
            operation.accept(manager);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            manager.close();
        }
    }
}