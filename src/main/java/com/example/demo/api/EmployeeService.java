package com.example.demo.api;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Optional<Employee> saveEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        employeeRepository.save(employee);
        return employeeRepository.findById(employee.getId());
    }

    @GetMapping
    public List<Employee>getAll(){
      return   employeeRepository.findAll();
    }

//    @GetMapping("/{dept}")
//    public  List<Employee>getEmployeeById(@PathVariable String dept){
//        return employeeRepository.findAllByDept(dept);
//    }
}
