package com.ria.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.ria.demo.DAO.ExamDAO;
import com.ria.demo.DAO.QuestionsDAO;
import com.ria.demo.DAO.ResultDAO;
import com.ria.demo.DAO.ResultLineDAO;
import com.ria.demo.DAO.StudentDAO;
import com.ria.demo.Entity.Exam;
import com.ria.demo.Entity.Questions;
import com.ria.demo.Entity.Result;
import com.ria.demo.Entity.ResultLine;
import com.ria.demo.Entity.Student;
import com.ria.demo.Service.StudentService;

@Controller
public class StudentExamController {

	@Autowired
	private ExamDAO examDAO;
	
	@Autowired
	private QuestionsDAO questionsDAO;
	
	@Autowired
	private ResultDAO resultDAO;
	
	@Autowired
	private ResultLineDAO resultLineDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	List<Questions> queList;
	
	List<ResultLine> resList;
	
	private Integer qtrack;
	
	private Result res;
	
	private Exam exam;
	
	
	@Autowired
	private StudentService stuser;
	
	//student page requests below
		@GetMapping("/studentpage")
		public ModelAndView studentpage() {
			ModelAndView mv=new ModelAndView();
			
			mv.setViewName("studentpage");
			return mv;
		}
		
		@GetMapping("/studentpage/examlist")
		public ModelAndView studentExamList(HttpServletRequest req) {
			ModelAndView mv=new ModelAndView();
			
			HttpSession session=req.getSession();
			
			Student stu=studentDAO.findById(Integer.parseInt(((String)session.getAttribute("username")).substring(3))).get();
			//stuser.getAllExamListByDeptandCourse(103, 3).forEach(st->System.out.println(st));
			
			mv.addObject("examlist", stuser.getAllExamListByDeptandCourse(stu.getDept_id(), stu.getYear()));
			mv.addObject("student", stu);
			mv.addObject("name", "Exam List");
			mv.setViewName("studentExamList");
			return mv;
		}
		
	@GetMapping("/studentpage/startexam/{examid}")
	public ModelAndView startexam(@PathVariable Integer examid,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		
		qtrack=0;
		
		HttpSession session=req.getSession();
		Student stu=studentDAO.findById(Integer.parseInt(((String)session.getAttribute("username")).substring(3))).get();
		
		exam=examDAO.findById(examid).get();
		
		boolean validateTime=stuser.validateExamTimingandDate(exam);
		System.out.println(validateTime);
		List<Exam> examlist=stuser.getAllExamListByDeptandCourse(stu.getDept_id(), stu.getYear());
		
//		if(validateTime==false)
//		{
//			mv.addObject("error", "Exam not started. Please contact with your teacher !!");
//			mv.addObject("flag", false);
//			mv.addObject("examlist", examlist);
//			mv.addObject("student", stu);
//			mv.addObject("name", "Exam List");
//			mv.setViewName("studentExamList");
//			return mv;
//		}
		
		if(res==null)
			res=new Result();
		
		if(resList==null)
			resList=new ArrayList<>();
		res.setExamid(examid);
		res.setStudid(stu.getStud_id());
		res.setCorrectQuestions(0);
		res.setGotMarks(0);

		
		try {
			queList=questionsDAO.find(examid);
			queList.get(0);
		} catch (Exception e) {
			mv.addObject("error", "Questions not added !!");
			mv.addObject("flag", false);
			mv.addObject("examlist", examlist);
			mv.addObject("student", stu);
			mv.addObject("name", "Exam List");
			mv.setViewName("studentExamList");
			return mv;
		}
		
		if(queList==null)
		{
			mv.addObject("error", "Questions not added !!");
			return mv;
		}
		
		Date d=new Date();
		System.out.println(d.toString());
		session.setAttribute("date",d.toString());
		
		mv.addObject("question", queList.get(qtrack));
		mv.addObject("queNo", qtrack+1);
		mv.addObject("exam", exam);
		mv.setViewName("startexam");
		return mv;
	}
	
	@GetMapping("/startexam/next")
	public ModelAndView nextQuestion()
	{
		ModelAndView mv=new ModelAndView();
		Questions ques=queList.get(++qtrack);
		System.out.println(ques);
		mv.addObject("question", ques);
		mv.addObject("queNo", qtrack+1);
		mv.addObject("exam", exam);
		mv.setViewName("startexam");
		return mv;
	}
	
	@GetMapping("/startexam/previous")
	public ModelAndView previousQuestion()
	{
		ModelAndView mv=new ModelAndView();
		Questions ques=queList.get(--qtrack);
		System.out.println(ques);
		mv.addObject("question", ques);
		mv.addObject("queNo", qtrack+1);
		mv.addObject("exam", exam);
		mv.setViewName("startexam");
		return mv;
	}
	
	@PostMapping("/startexam/submitquestion/{que_id}")
	public ModelAndView submitQuestion(@PathVariable Integer que_id,HttpServletRequest req)
	{	
		ModelAndView mv=new ModelAndView();
		
		ResultLine resLine=new ResultLine();

		resLine.setQue_id(que_id);
		
		String corAns=queList.get(qtrack).getCorrectAns();
		
		String selAns=req.getParameter("answer");
		
		if(selAns==null)
		{
			mv.addObject("error", "Select Answer !!");
			mv.addObject("flag",false);
			mv.addObject("question", queList.get(qtrack));
			mv.addObject("queNo", qtrack+1);
			mv.addObject("exam", exam);
			mv.setViewName("startexam");
			return mv;
			
		}
		System.out.println(selAns+" "+corAns );
		
		
		resLine.setSelAns(selAns);
		if(corAns.equals(selAns))
		{
			resLine.setIsCorrect(true);
			resLine.setMarks(queList.get(qtrack).getMarks());
			res.setCorrectQuestions(res.getCorrectQuestions()+1);
			res.setGotMarks(resLine.getMarks()+res.getGotMarks());
		}
		else
		{
			resLine.setIsCorrect(false);
			resLine.setMarks(0);
		}
		
		int ind=stuser.getResultLineFromList(resList,que_id);
		if(ind>=0)
		{
			resList.set(ind, resLine);
		}
		else
			resList.add(resLine);
		
		mv.addObject("success", "Answer submitted!!");
		mv.addObject("flag",true);
		mv.addObject("question", queList.get(qtrack));
		mv.addObject("queNo", qtrack+1);
		mv.addObject("exam", exam);
		mv.setViewName("startexam");
		return mv;	
	}
	
	@GetMapping("/startexam/submittest")
	public ModelAndView submitTest()
	{
		ModelAndView mv=new ModelAndView();
		res.setResList(resList);
		resultDAO.save(res);
		
		mv.setViewName("lastexampage");
		return mv;
	}
	
	@GetMapping("/studentpage/resultlist")
	public ModelAndView resultlist(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		
		HttpSession session=req.getSession();
		
		Student stu=studentDAO.findById(Integer.parseInt(((String)session.getAttribute("username")).substring(3))).get();
		
		List<Result> resultlist=resultDAO.findByStudid(stu.getStud_id());
		
		List<Exam> examlist=new ArrayList<>();
		Exam exam;
		
		for (int i = 0; i < resultlist.size(); i++) {
			
			exam=examDAO.findById(resultlist.get(i).getExamid()).get();
			double percent=(resultlist.get(i).getGotMarks()/exam.getTotalMarks())*100;
			if(percent>=40)
			{
				resultlist.get(i).setResStatus(true);
			}
			else
			{
				resultlist.get(i).setResStatus(false);
			}
			examlist.add(exam);
		}
		
		mv.addObject("resultlist", resultlist);
		mv.addObject("examlist", examlist);
		mv.addObject("student", stu);
		mv.addObject("name","Exam Results");
		mv.setViewName("resultpage");
		return mv;
		
	}
	
	@GetMapping("/studentpage/queresultpage/{result_id}")
	public ModelAndView resultQuestionsList(@PathVariable Integer result_id)
	{
		ModelAndView mv=new ModelAndView();
		
		Result res=resultDAO.findById(result_id).get();
		Exam exam=examDAO.findById(res.getExamid()).get();
		
		List<ResultLine> resList=resultLineDAO.find(result_id);
		List<Questions> quelist=new ArrayList<>();
		
		for (int j = 0; j < resList.size(); j++) {
			Questions que=questionsDAO.findById(resList.get(j).getQue_id()).get();
			quelist.add(que);
		}
		
		mv.addObject("resultlist", resList);
		mv.addObject("questionlist", quelist);
		mv.addObject("exam", exam);
		mv.addObject("result", res);
		mv.setViewName("queResultPage");
		return mv;
	}
}
