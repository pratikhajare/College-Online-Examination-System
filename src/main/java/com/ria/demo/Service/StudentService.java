package com.ria.demo.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ria.demo.DAO.CoursesDAO;
import com.ria.demo.DAO.ExamDAO;
import com.ria.demo.Entity.Courses;
import com.ria.demo.Entity.Exam;
import com.ria.demo.Entity.ResultLine;

@Service
public class StudentService  {

	@Autowired
	private CoursesDAO coursesDAO;
	
	@Autowired
	private ExamDAO examDAO;
	
	public List<Exam> getAllExamListByDeptandCourse(Integer deptid,Integer c_id)
	{
		List<Exam> examList=new ArrayList<>();
		
		List<Courses> clist=coursesDAO.find(deptid, c_id);
		//clist.forEach(co->System.out.println(co));
		
		for (Courses courses : clist) {
			examList.addAll(examDAO.findByCourseid(courses.getCourse_id()));
		}
		return examList;
	}
	
	public Boolean validateExamTimingandDate(Exam exam)
	{
		Date edate=exam.getExamdate();
		LocalTime st=exam.getStarttime();
		Date examdate=new Date(edate.getYear(),edate.getMonth(),edate.getDay(),st.getHour(),st.getMinute(),st.getSecond());
		
		Date vdate=exam.getDateValid();
		LocalTime en=exam.getStarttime();
		Date validdate=new Date(vdate.getYear(),vdate.getMonth(),vdate.getDay(),en.getHour(),en.getMinute(),en.getSecond());
		Date d=new Date();
		
		return d.after(examdate) && d.before(validdate);
	}

	public int getResultLineFromList(List<ResultLine> resList, Integer que_id) {
		ResultLine res=new ResultLine();
		res.setQue_id(que_id);
		return Collections.binarySearch(resList,res);
	}
	
}
