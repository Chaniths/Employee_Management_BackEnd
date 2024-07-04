package org.Laraza.Employee.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.Laraza.Employee.dto.Employee;
import org.Laraza.Employee.entity.EmployeeEntity;
import org.Laraza.Employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    final EmployeeRepository repository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void persist(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> retrieveAll() {
        Iterable<EmployeeEntity> all = repository.findAll();
        all.forEach(entity -> employeeList.add(mapper.convertValue(entity, Employee.class)));
        return employeeList;
    }

    @Override
    public void update(Employee employee) {

        repository.save(mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
