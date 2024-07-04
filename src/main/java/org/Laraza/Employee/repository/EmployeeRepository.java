package org.Laraza.Employee.repository;

import org.Laraza.Employee.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
}
