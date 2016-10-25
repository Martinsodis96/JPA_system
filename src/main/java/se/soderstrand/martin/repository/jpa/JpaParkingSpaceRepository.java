package se.soderstrand.martin.repository.jpa;

import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.repository.ParkingSpaceRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Martin on 2016-10-25.
 */
public final class JpaParkingSpaceRepository extends BaseRepository<ParkingSpace> implements ParkingSpaceRepository {

    public JpaParkingSpaceRepository(EntityManagerFactory factory) {
        super(ParkingSpace.class, factory);
    }

    @Override
    public List<ParkingSpace> getAll() {
        return null;
    }
}
