package com.csa.samplefullstack.controllers;

import com.csa.samplefullstack.entity.Employee;
import com.csa.samplefullstack.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    
    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    
    @GetMapping("/employees/{id}")
    public Employee getEmployeeFromId(@PathVariable long employeeId){
        return employeeRepository.findById(employeeId).get();
    }
    
    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    
    @DeleteMapping("/employees/[id}")
     public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long employeeId){
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
