package se.soderstrand.martin.service;

import se.soderstrand.martin.entity.Employee;
import se.soderstrand.martin.exception.RepositoryException;
import se.soderstrand.martin.exception.ServiceException;
import se.soderstrand.martin.repository.EmployeeRepository;

import java.util.List;

public final class EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void storeEmployee(Employee employee) throws ServiceException {
        try {
            employeeRepository.saveOrUpdate(employee);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to save employee with id: " + employee.getId());
        }
    }

    public void getEmployeeById(Long id) throws ServiceException {
        try{
            employeeRepository.findById(id);
        }catch (RepositoryException e){
            throw new ServiceException("Failed to get Employee with id: " + id);
        }
    }

    public void deleteEmployee(Employee employee) throws ServiceException {
        try {
            employeeRepository.delete(employee);
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to delete employee with id: " + employee.getId());
        }
    }

    public List<Employee> getAllEmployees() throws ServiceException {
        try {
            return employeeRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("Failed to get all Employees");
        }
    }
}
