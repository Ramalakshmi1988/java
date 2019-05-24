package com.galvanize.employeedb.Services;

import com.galvanize.employeedb.Entities.Employee;
import com.galvanize.employeedb.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private  EmployeeRepository repository;


    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return this.repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(long id) { return this.repository.findById(id); }
}
