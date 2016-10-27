package se.soderstrand.martin.service;

import org.junit.Before;
import org.junit.Test;
import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.jpa.JpaParkingSpaceRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public final class TestParkingSpaceService {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("JPA_system_test");

    private ParkingSpaceService parkingSpaceService;
    private ParkingSpace parkingSpace;
    private List<ParkingSpace> parkingSpaceToStore;


    @Before
    public void setUp() {
        this.parkingSpace = new ParkingSpace("temp", null);
        this.parkingSpaceToStore = new ArrayList<>();
        this.parkingSpaceService = new ParkingSpaceService(
                new JpaParkingSpaceRepository(FACTORY));
    }

    @Test
    public void canStoreParkingSpace() throws ServiceException {
        parkingSpaceService.storeParkingSpace(parkingSpace);

        deleteOneParkingSpace(parkingSpace);
    }

    @Test
    public void canFindParkingSpaceById() throws ServiceException {
        ParkingSpace storedParkingSpace = parkingSpaceService.storeParkingSpace(parkingSpace);
        ParkingSpace parkingSpaceFromSource = parkingSpaceService.
                getParkingById(storedParkingSpace.getId());
        assertEquals(parkingSpaceFromSource.getLabel(), parkingSpace.getLabel());

        deleteOneParkingSpace(parkingSpace);
    }

    @Test
    public void canGetAllEmployees() throws ServiceException {
        generateParkingSpaces(5);
        for (ParkingSpace park : parkingSpaceToStore) {
            parkingSpaceService.storeParkingSpace(park);
        }
        List<ParkingSpace> parkingSpacesFromSource = parkingSpaceService.getAllParkingSpaces();
        assertEquals(parkingSpacesFromSource.size(), parkingSpaceToStore.size());

        deleteManyParkingSpaces(parkingSpacesFromSource);
    }

    @Test
    public void canDeleteEmployee() throws ServiceException {
        ParkingSpace createdParkingSpace = parkingSpaceService.storeParkingSpace(parkingSpace);
        ParkingSpace parkingSpaceBeforeDeleted = parkingSpaceService.getParkingById(createdParkingSpace.getId());
        parkingSpaceService.deleteParkingSpace(createdParkingSpace);
        ParkingSpace parkingSpaceAfterDeleted = parkingSpaceService.getParkingById(createdParkingSpace.getId());

        assertNotNull(parkingSpaceBeforeDeleted);
        assertNull(parkingSpaceAfterDeleted);
    }

    private void deleteOneParkingSpace(ParkingSpace parkingSpace) throws ServiceException {
        parkingSpaceService.deleteParkingSpace(parkingSpace);
    }

    private void deleteManyParkingSpaces(List<ParkingSpace> parkingSpaces) throws ServiceException {
        for (ParkingSpace park : parkingSpaces) {
            parkingSpaceService.deleteParkingSpace(park);
        }
    }

    private void generateParkingSpaces(int amount){
        for (int i = 0; i < amount; i++) {
            parkingSpaceToStore.add(new ParkingSpace("temp", null));
        }
    }
}
