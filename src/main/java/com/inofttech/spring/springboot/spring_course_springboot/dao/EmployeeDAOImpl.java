package com.inofttech.spring.springboot.spring_course_springboot.dao;

import com.inofttech.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        /*Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee",
                Employee.class);*/
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        /*Session session = entityManager.unwrap(Session.class);*/
        /*session.saveOrUpdate(employee);*/
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployeeById(int id) {
        /*Session session = entityManager.unwrap(Session.class);*/
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);    }

    @Override
    public void deleteEmployeeById(int id) {
        /*Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*/
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
