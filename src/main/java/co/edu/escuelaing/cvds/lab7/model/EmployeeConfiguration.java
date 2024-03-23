package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeConfiguration {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Role")
    private String role;

    @Column(name = "Salary")
    private Double salary;


}
