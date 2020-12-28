package com.inofttech.spring.springboot.spring_course_springboot.dao;




import com.inofttech.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();


    public void saveEmployee(Employee employee);


    Employee getEmployeeById(int id);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
