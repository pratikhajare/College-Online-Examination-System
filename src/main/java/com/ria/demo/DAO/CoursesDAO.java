package com.ria.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ria.demo.Entity.Courses;

public interface CoursesDAO extends JpaRepository<Courses, Integer>{
	
	@Query("SELECT c FROM Courses c WHERE dept_id =:dept_id and year=:year")
    public List<Courses> find(@Param("dept_id") Integer dept_id,@Param("year") Integer year);
	
}
