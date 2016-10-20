package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.ParkingSpaceRepository;

import java.util.List;

public final class ParkingSpaceService {

    private ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceService(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    public void saveParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceRepository.create(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to create Parking Space with id: " + parkingSpace.getId());
        }
    }

    public List<ParkingSpace> getAllParkingSpaces() throws ServiceException {
        try {
            return parkingSpaceRepository.getAll(ParkingSpace.class);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all Parking Spaces");
        }
    }
}
