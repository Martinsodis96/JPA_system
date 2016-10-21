package se.soderstrand.martin.repository;

import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.repository.crud.BaseRepository;

import java.util.List;

public final class ParkingSpaceRepository extends BaseRepository<ParkingSpace> {

    @Override
    public void create(ParkingSpace parkingSpace) throws RepositoryException {
        super.create(parkingSpace);
    }

    @Override
    public ParkingSpace read(Long id, Class<ParkingSpace> parkingSpace) throws RepositoryException {
        return super.read(id, parkingSpace);
    }

    @Override
    public void update(ParkingSpace parkingSpace) {
        super.update(parkingSpace);
    }

    @Override
    public void changeStatus(ParkingSpace parkingSpace) {
        super.changeStatus(parkingSpace);
    }

    @Override
    public List<ParkingSpace> getAll(Class type) throws RepositoryException {
        return super.getAll(type);
    }
}
