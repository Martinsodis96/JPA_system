package se.soderstrand.martin.service;

import org.junit.Before;
import org.junit.Test;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.repository.jpa.JpaEmployeeRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public final class TestEmployeeService {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("JPA_system_test");

    private EmployeeService employeeService;
    private Employee employee;
    private List<Employee> employeesToStore;


    @Before
    public void setUp() {
        this.employee = new Employee("test", "test", "test", null);
        this.employeesToStore = new ArrayList<>();
        this.employeeService = new EmployeeService(
                new JpaEmployeeRepository(FACTORY));
    }

    @Test
    public void canStoreEmployee() throws ServiceException {
        employeeService.storeEmployee(employee);

        deleteOneEmployee(employee);
    }

    @Test
    public void canFindEmployeeById() throws ServiceException {
        Employee storedEmployee = employeeService.storeEmployee(employee);
        Employee employeeFromSource = employeeService.
                getEmployeeById(storedEmployee.getId());
        assertEquals(employeeFromSource.getFirstName(), employee.getFirstName());

        deleteOneEmployee(employee);
    }

    @Test
    public void canGetAllEmployees() throws ServiceException {
        generateEmployees(5);
        for (Employee emp : employeesToStore) {
            employeeService.storeEmployee(emp);
        }
        List<Employee> employeesFromSource = employeeService.getAllEmployees();
        assertEquals(employeesFromSource.size(), employeesToStore.size());

        deleteManyEmployees(employeesFromSource);
    }

    @Test
    public void canDeleteEmployee() throws ServiceException {
        Employee createdEmployee = employeeService.storeEmployee(employee);
        Employee employeeBeforeDeleted = employeeService.getEmployeeById(createdEmployee.getId());
        employeeService.deleteEmployee(createdEmployee);
        Employee employeeAfterDeleted = employeeService.getEmployeeById(createdEmployee.getId());

        assertNotNull(employeeBeforeDeleted);
        assertNull(employeeAfterDeleted);
    }

    private void deleteOneEmployee (Employee employee) throws ServiceException {
        employeeService.deleteEmployee(employee);
    }

    private void deleteManyEmployees(List<Employee> employees) throws ServiceException {
        for (Employee emp : employees) {
            employeeService.deleteEmployee(emp);
        }
    }

    private void generateEmployees(int amount){
        for (int i = 0; i < amount; i++) {
            employeesToStore.add(new Employee("Test" + i, "Test" + i, "temp", null));
        }
    }
}
