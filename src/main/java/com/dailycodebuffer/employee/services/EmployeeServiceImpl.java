package com.dailycodebuffer.employee.services;


import com.dailycodebuffer.employee.entity.*;
import com.dailycodebuffer.employee.model.*;
import com.dailycodebuffer.employee.repository.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl (EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;

    }


    @Override
    public Employee createEmployee(Employee employee) {

    //for copying all the values of the employee.. to the employee entity (the value in the database )
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        //save method already available in the employeeRepository as we have extended JPA repository

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        //getting all the employee entities as a list from repository using java springdata jpa
        //that's exactly where .findAll method comes from.....

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        //converting all employee entities into employee so that it can be sent back to a react object

        List<Employee> employees = employeeEntities
                .stream()
                .map( ( EmployeeEntity emp )-> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
//    this emp -> new Employee is NOT LAMBDA EXPRESSION ....but an implementation of streams
//    which lets us copy data from one array to another array while editing it
        return employees;


    }

    @Override
    public boolean deleteEmployee(Long id) {
    EmployeeEntity employee = employeeRepository.findById(id).get();
    employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity,employee);

        return employee;

    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

         employeeEntity.setEmailId(employee.getEmailId());
         employeeEntity.setFirstName(employee.getFirstName());
         employeeEntity.setLastName(employee.getLastName());

         employeeRepository.save(employeeEntity);

        return employee;




    }
}
