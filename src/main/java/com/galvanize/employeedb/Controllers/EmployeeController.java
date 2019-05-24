package com.galvanize.employeedb.Controllers;

import com.galvanize.employeedb.Entities.Employee;
import com.galvanize.employeedb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/")
    public String getAppName(){
        return "Employee App";
    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> all(){ return employeeService.getAllEmployees(); }

    @PostMapping("/")
    public Employee save(@RequestBody Employee employee) { return employeeService.saveEmployee(employee); }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable("id")  Long id) { return employeeService.getEmployeeById(id); }
}
