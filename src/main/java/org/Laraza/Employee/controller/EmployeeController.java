package org.Laraza.Employee.controller;

import lombok.RequiredArgsConstructor;
import org.Laraza.Employee.dto.Employee;
import org.Laraza.Employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    final EmployeeService service;


    @PostMapping("/persist")
    public void persist(@RequestBody Employee employee) {
        service.persist(employee);
    }

    @GetMapping("/retrieveAll")
    public List<Employee> getAll(){
       return service.retrieveAll();
    }

    @PatchMapping("/update")
    public void update(@RequestBody Employee employee){
           service.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean delete(@PathVariable Long id){
        return service.deleteEmployeeById(id);
    }

}
