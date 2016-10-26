package se.soderstrand.martin;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.jpa.JpaDepartmentRepository;
import se.soderstrand.martin.repository.ParkingSpaceRepository;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.repository.jpa.JpaEmployeeRepository;
import se.soderstrand.martin.repository.jpa.JpaParkingSpaceRepository;
import se.soderstrand.martin.service.DepartmentService;
import se.soderstrand.martin.service.EmployeeService;
import se.soderstrand.martin.service.ParkingSpaceService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Martin on 2016-10-20.
 */
public final class Main {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("JPA_system");

    public static void main(String[] args) {
        //Repo
        ParkingSpaceRepository parkingSpaceRepository = new JpaParkingSpaceRepository(FACTORY);
        EmployeeRepository employeeRepository = new JpaEmployeeRepository(FACTORY);
        DepartmentRepository departmentRepository = new JpaDepartmentRepository(FACTORY);

        //Service
        ParkingSpaceService parkingSpaceService = new ParkingSpaceService(parkingSpaceRepository);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        DepartmentService departmentService = new DepartmentService(departmentRepository);

        //dummy entities
        Department department = new Department("Hotel");
        Employee employee1 = new Employee("Martin", "Söderstrand", "10", department);
        Employee employee2 = new Employee("Martina", "Söderstrand", "20", department);
        ParkingSpace parkingSpace = new ParkingSpace("test", employee1);

        try {
            departmentService.storeDepartment(department);
            employeeService.storeEmployee(employee1);
            employeeService.storeEmployee(employee2);
            parkingSpaceService.storeParkingSpace(parkingSpace);

            parkingSpaceService.getAllParkingSpaces().forEach(parkingSpace1 ->
                    System.out.println(parkingSpace1.getEmployee()));

            parkingSpaceService.deleteParkingSpace(parkingSpace);
            employeeService.deleteEmployee(employee1);
            employeeService.deleteEmployee(employee2);
            departmentService.deleteDepartment(department);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}