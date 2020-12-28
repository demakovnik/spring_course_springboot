package com.inofttech.spring.springboot.spring_course_springboot.service;




import com.inofttech.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployeeById(int id);
}
