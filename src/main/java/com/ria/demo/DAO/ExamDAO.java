package com.ria.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ria.demo.Entity.Exam;

@Repository
public interface ExamDAO extends JpaRepository<Exam, Integer>{
	
	List<Exam> findByCourseid(Integer courseid);
	List<Exam> findByEmpid(int empid);
}
