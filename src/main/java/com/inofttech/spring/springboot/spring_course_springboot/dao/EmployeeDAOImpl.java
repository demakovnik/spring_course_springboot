package com.inofttech.spring.springboot.spring_course_springboot.dao;

import com.inofttech.spring.springboot.spring_course_springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee",
                Employee.class);
        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }
/*
    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }*/
}
