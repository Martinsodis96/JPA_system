package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.CrudRepository;

import java.util.List;

public interface ParkingSpaceRepository extends CrudRepository<ParkingSpace> {

    List<ParkingSpace> getAll() throws RepositoryException;

}
