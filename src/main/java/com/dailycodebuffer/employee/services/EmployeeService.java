package com.dailycodebuffer.employee.services;

import com.dailycodebuffer.employee.model.*;

import java.util.*;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
