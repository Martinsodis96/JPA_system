package se.soderstrand.martin.repository.jpa;

import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.repository.ParkingSpaceRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

import static java.util.function.UnaryOperator.identity;

public final class JpaParkingSpaceRepository extends BaseRepository<ParkingSpace> implements ParkingSpaceRepository {

    public JpaParkingSpaceRepository(EntityManagerFactory factory) {
        super(ParkingSpace.class, factory);
    }

    @Override
    public List<ParkingSpace> getAll() {
        return query("ParkingSpace.GetAll", identity());
    }
}
