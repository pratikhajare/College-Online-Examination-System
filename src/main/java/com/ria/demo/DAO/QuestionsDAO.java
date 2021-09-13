package com.ria.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ria.demo.Entity.Questions;

public interface QuestionsDAO extends JpaRepository<Questions, Integer>{
	
	@Query("SELECT q FROM Questions q WHERE exam_id =:exam_id")
    public List<Questions> find(@Param("exam_id") Integer exam_id);
	
}
