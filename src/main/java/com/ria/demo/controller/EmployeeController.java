package com.ria.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ria.demo.DAO.CoursesDAO;
import com.ria.demo.DAO.EmployeeDAO;
import com.ria.demo.DAO.ExamDAO;
import com.ria.demo.DAO.ResultDAO;
import com.ria.demo.DAO.StudentDAO;
import com.ria.demo.Entity.Courses;
import com.ria.demo.Entity.Employee;
import com.ria.demo.Entity.Exam;
import com.ria.demo.Entity.Questions;
import com.ria.demo.Entity.Result;
import com.ria.demo.Entity.Student;

@Controller
public class EmployeeController {

	@Autowired
	private ExamDAO examDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private CoursesDAO coursesDAO;
	
	@Autowired
	private ResultDAO resultDAO;
	
	private Exam exam;
	
	List<Questions> queList;

	//teacher page requests below
	@GetMapping("/teacherpage")
	public ModelAndView teacherpage(HttpServletRequest req) {
		
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("name", "Employee Page");
		mv.setViewName("teacherpage");
		return mv;
	}
	
	@GetMapping("/teacherpage/addexam")
	public ModelAndView addExam(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("name", "Add Exam");
		HttpSession session=req.getSession();
		Employee employee=employeeDAO.findById(Integer.parseInt(((String) session.getAttribute("username")).substring(3))).get();
				
		Courses c1=coursesDAO.findById(employee.getCourse_id1()).get();
		Courses c2=coursesDAO.findById(employee.getCourse_id2()).get();
		mv.addObject("course1", c1.getC_name());
		mv.addObject("course2", c2.getC_name());
		mv.addObject("c1", c1.getCourse_id());
		mv.addObject("c2", c2.getCourse_id());
		
		mv.addObject("uname", session.getAttribute("uname"));
		mv.setViewName("teacher_addexam");
		return mv;
	}
	
	@PostMapping("/teacherpage/addexam")
	public ModelAndView postAddExam(HttpServletRequest req) throws ParseException
	{
		ModelAndView mv=new ModelAndView();

		int courseid=Integer.parseInt(req.getParameter("selExam"));
		
		HttpSession session=req.getSession();
		Employee employee=employeeDAO.findById(Integer.parseInt(((String) session.getAttribute("username")).substring(3))).get();
		
		Courses c1=coursesDAO.findById(employee.getCourse_id1()).get();
		Courses c2=coursesDAO.findById(employee.getCourse_id2()).get();
		mv.addObject("course1", c1.getC_name());
		mv.addObject("course2", c2.getC_name());
		mv.addObject("c1", c1.getCourse_id());
		mv.addObject("c2", c2.getCourse_id());
		
		if(courseid==0)
		{
			mv.addObject("flag", false);
			mv.addObject("error","Select Exam name !!");
			mv.setViewName("teacher_addexam");
			return mv;
		}
		
		LocalDateTime dateOfCreation = LocalDateTime.now();
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date examdate = formatter.parse(req.getParameter("examdate"));		
		Date validdate = formatter.parse(req.getParameter("validdate"));
		
		LocalTime st = LocalTime.parse( req.getParameter("starttime"));
		LocalTime en = LocalTime.parse( req.getParameter("endtime")) ;
		
		float duration=Float.parseFloat(req.getParameter("duration"));
		
		Exam e=new Exam();
		e.setEmpid(employee.getEmpid());
		e.setExamname(coursesDAO.findById(courseid).get().getC_name());
		e.setDateOfCreation(dateOfCreation);
		e.setDateValid(validdate);
		e.setExamdate(examdate);
		e.setStarttime(st);
		e.setEndTime(en);
		e.setDuration(duration);
		e.setNoOfQuestions(0);
		e.setTotalMarks(0);
		e.setCourseid(courseid);
		
		
		if(duration>=24)
		{
			mv.addObject("flag", false);
			mv.addObject("error","Enter correct duration !!");
			mv.addObject("exam", e);
			mv.setViewName("teacher_addexam");
			return mv;
		}
		if(examdate.after(validdate))
		{
			mv.addObject("flag", false);
			mv.addObject("error","Check exam dates !!");
			mv.addObject("exam", e);
			mv.setViewName("teacher_addexam");
			return mv;
		}
		else if(examdate.equals(validdate))
		{
			if(st.isAfter(en) || ((st.getHour()+(int)duration)%24)>en.getHour())
			{
				mv.addObject("flag", false);
				mv.addObject("error","Check Start time & End time !!");
				mv.addObject("exam", e);
				mv.addObject("uname", session.getAttribute("uname"));
				mv.setViewName("teacher_addexam");
				return mv;
			}
		}
		else if((((st.getHour()+1)%24)>en.getHour()) && examdate.before(validdate))
		{
			mv.addObject("flag", false);
			mv.addObject("error","Check Start time & End time !!");
			mv.addObject("exam", e);
			mv.addObject("uname", session.getAttribute("uname"));
			mv.setViewName("teacher_addexam");
			return mv;
		}
		
		examDAO.save(e);
		
		mv.addObject("flag", true);
		mv.addObject("success", "Exam added successfully !!");
		mv.setViewName("teacher_addexam");
		mv.addObject("uname", session.getAttribute("uname"));
		return mv;
	}
	
	
	@GetMapping("/teacherpage/examlist")
	public ModelAndView teacherExamList(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
	
		HttpSession session=req.getSession();
		
		List<Exam> examlist=examDAO.findByEmpid(Integer.parseInt(((String)session.getAttribute("username")).substring(3)));
		//examlist.forEach(exam->System.out.println(exam));
		mv.addObject("examlist", examlist);
		
		mv.addObject("name", "Exam List");
		mv.setViewName("teacherExamList");
		return mv;
	}
		
	@GetMapping("/teacherpage/addquestion/{eid}")
	public ModelAndView addQuestion(@PathVariable String eid, HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		
		
		int examid=Integer.parseInt(eid);
		exam=examDAO.findById(examid).get();
		
		mv.addObject("name", "Add Question");
		mv.addObject("examname", exam.getExamname());
		mv.setViewName("addquestion");
		return mv;
	}
	
	@PostMapping("/addquestion/save")
	public ModelAndView saveQuestion(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		
		Questions que=new Questions();
		que.setQuestion(req.getParameter("question"));
		que.setAns1(req.getParameter("ans1"));
		que.setAns2(req.getParameter("ans2"));
		que.setAns3(req.getParameter("ans3"));
		que.setAns4(req.getParameter("ans4"));
		que.setCorrectAns(req.getParameter("correctAns"));
		que.setMarks(Integer.parseInt(req.getParameter("marks")));
		
		if(queList==null)
			queList=new ArrayList<Questions>();
		exam.setNoOfQuestions(exam.getNoOfQuestions()+1);
		exam.setTotalMarks(exam.getTotalMarks()+que.getMarks());
		queList.add(que);
		
		mv.addObject("examname", exam.getExamname());
		mv.setViewName("addquestion");
		return mv;
	}
	
	@GetMapping("/addquestion/addAllQuestions")
	public ModelAndView addAllQuestions()
	{
		ModelAndView mv=new ModelAndView();

		exam.setQuestions(queList);
		examDAO.save(exam);
		
		mv.addObject("examname", exam.getExamname());
		mv.addObject("success", "Questions added successfully");
		mv.setViewName("addquestion");
		return mv;
	}
	
	@GetMapping("/teacherpage/viewresults")
	public ModelAndView viewResult(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		
		HttpSession session=req.getSession();
		Employee employee=employeeDAO.findById(Integer.parseInt(((String) session.getAttribute("username")).substring(3))).get();
		
		List<Exam> elist=examDAO.findByEmpid(employee.getEmpid());
		
		List<Result> rlist=new ArrayList<>();
		
		for (int i = 0; i < elist.size(); i++) {
			rlist.addAll(resultDAO.findByExamid(elist.get(i).getExam_id()));
		}
		
		List<Student> slist=new ArrayList<>();
		List<Exam> examlist=new ArrayList<>();
		
		for (int i = 0; i < rlist.size(); i++) {
			slist.add(studentDAO.findById(rlist.get(i).getStudid()).get());
			examlist.add(examDAO.findById(rlist.get(i).getExamid()).get());
		}
		
		mv.addObject("examlist", examlist);
		mv.addObject("studentlist", slist);
		mv.addObject("resultlist", rlist);
		mv.addObject("name", "Students Results");
		mv.setViewName("viewresults");
		return mv;
	}
	//teacher page requests over	

}
