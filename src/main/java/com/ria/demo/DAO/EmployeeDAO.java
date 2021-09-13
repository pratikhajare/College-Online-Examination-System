package com.ria.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ria.demo.Entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
