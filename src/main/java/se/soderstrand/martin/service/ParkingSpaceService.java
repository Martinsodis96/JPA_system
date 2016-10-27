package se.soderstrand.martin.service;

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

    public ParkingSpace storeParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceRepository.saveOrUpdate(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to create Parking Space with id: " + parkingSpace.getId());
        }
        return parkingSpace;
    }

    public ParkingSpace getParkingById(Long id) throws ServiceException{
        try {
            return parkingSpaceRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save Parking space with id: " + id);
        }
    }


    public ParkingSpace deleteParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            return parkingSpaceRepository.delete(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete parking space with id: " + parkingSpace.getId());
        }
    }

    public List<ParkingSpace> getAllParkingSpaces() throws ServiceException {
        try {
            return parkingSpaceRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all Parking Spaces");
        }
    }
}
