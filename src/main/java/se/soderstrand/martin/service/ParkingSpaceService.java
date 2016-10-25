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

    public void saveParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceRepository.create(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to create Parking Space with id: " + parkingSpace.getId());
        }
    }

    public ParkingSpace getParking(Long id) throws ServiceException{
        try {
            return parkingSpaceRepository.read(id, ParkingSpace.class);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save Parking space with id: " + id);
        }
    }


    public void deleteParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceRepository.delete(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete parking space with id: " + parkingSpace.getId());
        }
    }

    public List<ParkingSpace> getAllParkingSpaces() throws ServiceException {
        try {
            return parkingSpaceRepository.getAll(ParkingSpace.class);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all Parking Spaces");
        }
    }

    public void updateParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        try {
            parkingSpaceRepository.update(parkingSpace);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to update parking space with id: " + parkingSpace.getId());
        }
    }
}
