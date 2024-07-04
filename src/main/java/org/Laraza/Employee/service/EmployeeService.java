package org.Laraza.Employee.service;

import org.Laraza.Employee.dto.Employee;

import java.util.List;

public interface EmployeeService {

    void persist(Employee employee);

    List<Employee> retrieveAll();

    void update(Employee employee);

    boolean deleteEmployeeById(Long id);
}
