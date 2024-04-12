package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getAllEmployees(@PathVariable("id") String id){
        return this.employeeService.getEmployeebyid(id);
    }

    @GetMapping("/employee_name")
    public List<Employee> getEmployeeName(@RequestParam String firstName, @RequestParam String lastName){
        return employeeRepository.findByNameOrSurname(firstName, lastName);
    }

    @PostMapping("/addEmployee")
    public void createEmployee(@RequestBody Employee newEmployee) {
        employeeService.addEmployee(newEmployee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    updatedEmployee.setEmployeeId(id);
                    return employeeRepository.save(updatedEmployee);
                });
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}