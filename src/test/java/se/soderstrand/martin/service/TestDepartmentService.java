package se.soderstrand.martin.service;

import org.junit.Before;
import org.junit.Test;
import se.soderstrand.martin.entity.Department;
import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.DepartmentRepository;
import se.soderstrand.martin.repository.EmployeeRepository;
import se.soderstrand.martin.repository.jpa.JpaDepartmentRepository;
import se.soderstrand.martin.repository.jpa.JpaEmployeeRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class TestDepartmentService {

    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("JPA_system_test");

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;
    private EmployeeService employeeService;
    private Department department;
    private List<Department> departmentsToStore;


    @Before
    public void setUp() {
        this.department = new Department("test");
        this.departmentsToStore = new ArrayList<>();
        this.departmentRepository =  new JpaDepartmentRepository(FACTORY);
        this.employeeRepository = new JpaEmployeeRepository(FACTORY);
        this.departmentService = new DepartmentService(departmentRepository);
        this.employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void canStoreDepartment() throws ServiceException {
        departmentService.storeDepartment(department);

        deleteOneDepartment(department);
    }

    @Test
    public void canFindDepartmentById() throws ServiceException {
        Department storedDepartment = departmentService.storeDepartment(department);
        Department departmentFromSource = departmentService.getDepartmentById(storedDepartment.getId());
        assertEquals(departmentFromSource.getName(), department.getName());

        deleteOneDepartment(departmentFromSource);
    }

    @Test
    public void canGetAllDepartments() throws ServiceException {
        generateDepartments(5);
        for (Department dep : departmentsToStore) {
            departmentService.storeDepartment(dep);
        }
        List<Department> departmentsFromSource = departmentService.getAllDepartments();
        assertEquals(departmentsFromSource.size(), departmentsToStore.size());

        deleteManyDepartments(departmentsToStore);
    }

    @Test
    public void canDeleteDepartment() throws ServiceException {
        Department createdDepartment = departmentService.storeDepartment(department);
        Department departmentBeforeDeleted = departmentService.getDepartmentById(createdDepartment.getId());
        departmentService.deleteDepartment(createdDepartment);
        Department departmentAfterDeleted = departmentService.getDepartmentById(createdDepartment.getId());

        assertNotNull(departmentBeforeDeleted);
        assertNull(departmentAfterDeleted);
    }

    @Test
    public void canGetAllEmployeesFromDepartment() throws Exception {
        Department createdDepartment = departmentService.storeDepartment(department);
        int employeesInDepartment = 3;

        for (int i = 0; i < employeesInDepartment; i++) {
            employeeService.storeEmployee(new Employee("Test" + i, "Test" + i, "temp", department));
        }

        Collection<Employee> employeesFromSource = departmentService.getEmployeesFromDepartment(createdDepartment.getId());
        assertEquals(employeesFromSource.size(), employeesInDepartment);
    }

    private void deleteOneDepartment(Department department) throws ServiceException {
        departmentService.deleteDepartment(department);
    }

    private void deleteManyDepartments(List<Department> departments) throws ServiceException {
        for (Department dep : departments) {
            departmentService.deleteDepartment(dep);
        }
    }

    private void generateDepartments(int amount){
        for (int i = 0; i < amount; i++) {
            departmentsToStore.add(new Department("test" + i));
        }
    }
}
