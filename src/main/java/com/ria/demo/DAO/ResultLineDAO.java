package com.ria.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ria.demo.Entity.ResultLine;

public interface ResultLineDAO extends JpaRepository<ResultLine, Integer> {
	
	@Query("SELECT res FROM ResultLine res WHERE result_id =:result_id")
    public List<ResultLine> find(@Param("result_id") Integer result_id);
}
