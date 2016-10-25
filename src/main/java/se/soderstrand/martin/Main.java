package se.soderstrand.martin;

import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.entity.ParkingSpace;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.ParkingSpaceRepository;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.repository.crud.BaseRepository;
import se.soderstrand.martin.repository.crud.CrudRepository;
import se.soderstrand.martin.service.DepartmentService;
import se.soderstrand.martin.service.EmployeeService;
import se.soderstrand.martin.service.ParkingSpaceService;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

/**
 * Created by Martin on 2016-10-20.
 */
public final class Main {
    public static void main(String[] args) {
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
        Employee employee1 = new Employee("Martin", "Söderstrand", "10", department);
        Employee employee2 = new Employee("Martina", "Söderstrand", "20", department);
        ParkingSpace parkingSpace = new ParkingSpace("test", employee1);

        try {
            departmentService.saveDepartment(department);
            employeeService.saveEmployee(employee1);
            employeeService.saveEmployee(employee2);

            Department department1 = departmentService.getDepartment(1L);
            Collection<Employee> employees = department1.getEmployees();
            employees.forEach(e -> System.out.println(e.getFirstName()));

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
