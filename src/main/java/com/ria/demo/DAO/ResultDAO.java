package com.ria.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ria.demo.Entity.Result;

public interface ResultDAO extends JpaRepository<Result, Integer>{
	
	List<Result> findByStudid(Integer studid);
	List<Result> findByExamid(Integer examid);
}
