package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public final class EmployeeService extends Service{

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) throws ServiceException {
        try {
            employeeRepository.create(employee);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save employee with id: " + employee.getId());
        }
    }

    public List<Employee> getAllEmployees() throws ServiceException {
        try {
            return employeeRepository.getAll(Employee.class);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all Employees");
        }
    }
}
