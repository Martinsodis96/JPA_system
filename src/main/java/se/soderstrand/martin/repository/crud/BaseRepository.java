package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.exception.RepositoryException;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public abstract class BaseRepository<T> implements CrudRepository<T> {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("JPA_system");

    private EntityManager manager;

    @Override
    public void create(T t) throws RepositoryException {
        try{
            manager = FACTORY.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(t);
            manager.getTransaction().commit();
        }catch (Exception e){
            manager.getTransaction().rollback();
            throw new RepositoryException("Failed to create entity");
        }finally {
            manager.close();
        }
    }

    @Override
    public T read(Long id) throws RepositoryException {
        return null;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void changeStatus(T t) {

    }

    @Override
    public List<T> getAll(Class type) throws RepositoryException {
        try{
            manager = FACTORY.createEntityManager();
            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT u FROM " + type.getName() + " u", type);
            manager.getTransaction().commit();
            return query.getResultList();
        }catch (Exception e){
            manager.getTransaction().rollback();
            throw new RepositoryException("Failed to create entity");
        }finally {
            manager.close();
        }
    }
}
