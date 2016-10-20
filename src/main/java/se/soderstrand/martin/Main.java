package se.soderstrand.martin;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.ParkingSpaceRepository;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.service.DepartmentService;
import se.soderstrand.martin.service.EmployeeService;
import se.soderstrand.martin.service.ParkingSpaceService;

import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public final class Main {
    public static void main(String [] args){
        //Repo
        ParkingSpaceRepository parkingSpaceRepository = new ParkingSpaceRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();

        //Service
        ParkingSpaceService parkingSpaceService = new ParkingSpaceService(parkingSpaceRepository);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        DepartmentService departmentService = new DepartmentService(departmentRepository);

        //dummy entities
        Department department = new Department("Hotel");
        Employee employee = new Employee("Martin", "Söderstrand", "1", department);
        ParkingSpace parkingSpace = new ParkingSpace("test", employee);

        try {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee);
            parkingSpaceService.saveParkingSpace(parkingSpace);

            List<Employee> employees = employeeService.getAllEmployees();
            employees.forEach(System.out::println);

            List<ParkingSpace> parkingSpaces = parkingSpaceService.getAllParkingSpaces();
            parkingSpaces.forEach(parkingSpace1 -> System.out.println(parkingSpace1.getEmployee().getId()));

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
