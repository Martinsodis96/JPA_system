package se.soderstrand.martin.repository.crud;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;

import javax.persistence.*;
import java.util.List;

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
    public T read(Long id, Class<T> t) throws RepositoryException {
        try{
            manager = FACTORY.createEntityManager();
            manager.getTransaction().begin();
            T foundEntity = manager.find(t, id);
            manager.getTransaction().commit();
            return foundEntity;
        }catch (Exception e){
            manager.getTransaction().rollback();
            throw new RepositoryException("Failed to create entity");
        }finally {
            manager.close();
        }
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void changeStatus(T t) {

    }

    @Override
    public List<T> getAll(Class<T> type) throws RepositoryException {
        try{
            manager = FACTORY.createEntityManager();
            manager.getTransaction().begin();
            TypedQuery<T> query = manager.createQuery("SELECT t FROM " + type.getName() + " t", type);
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
