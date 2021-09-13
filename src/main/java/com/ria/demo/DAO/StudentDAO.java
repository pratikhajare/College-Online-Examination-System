package com.ria.demo.DAO;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ria.demo.Entity.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {
	
}
