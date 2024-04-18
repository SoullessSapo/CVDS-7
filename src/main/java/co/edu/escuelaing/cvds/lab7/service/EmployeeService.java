package co.edu.escuelaing.cvds.lab7.service;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public void addEmployee(Employee employee){employeeRepository.save(employee);}
    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }
    public List<Employee> getAllEmployees() {return employeeRepository.findAll();}
    public Employee getEmployeebyid(String id){return employeeRepository.findById(id).get();}
}
