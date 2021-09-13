package com.ria.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ria.demo.DAO.CoursesDAO;
import com.ria.demo.DAO.EmployeeDAO;
import com.ria.demo.DAO.StudentDAO;
import com.ria.demo.Entity.Employee;
import com.ria.demo.Entity.Student;

@Controller
public class PageController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private CoursesDAO coursesDAO;
	
	
	
	@RequestMapping(value = {"/","/home"},method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		
		HttpSession session=req.getSession();
		
		String username="";
		try {
			username=(String) session.getAttribute("username");
		} catch (Exception e) {
		}
		if(username!=null )
		{	
			if(!username.equals(""))
			{
				mv.addObject("uname", session.getAttribute("uname"));
				mv.addObject("flag", true);
				mv.addObject("name", "Home");
				mv.setViewName("home");
			}
		}
		else
		{
			mv.addObject("flag", false);
			mv.addObject("name", "Home");
			mv.setViewName("home");
		}
			return mv;
	}
	
	//login request below
	@RequestMapping(value = "/signin",method=RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "Sign In");
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping("/signin")
	public ModelAndView postSignin(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		System.out.println(username+" "+password);
		
		HttpSession session=req.getSession();
		
		
		mv.addObject("name", "Sign In");
		Student stu=null;
		Employee employee=null;
		if(!username.equals("") && !password.equals(""))
		{
			if(username.startsWith("STU") && username.length()==6)
			{
				try
				{
					stu=studentDAO.findById(Integer.parseInt(username.substring(3))).get();
				}
				catch(Exception e)
				{
					mv.addObject("error", "You Have Entered Wrong Registration Id !!");
					mv.addObject("flag",false);
					mv.setViewName("login");
					return mv;
				}		
				if(stu!=null && stu.getPassword().equals(password))
				{
					session.setAttribute("username",username);
					session.setAttribute("uname", stu.getName().getFname()+" "+stu.getName().getLname());
					
					mv.addObject("success", "Welcome "+stu.getName().getFname()+", you are logged in !!");
					mv.addObject("student", stu);
					mv.addObject("flag",true);
					mv.setViewName("studentpage");
					return mv;
				}
				else
				{
					mv.addObject("error", "Wrong Registration Id or Password !!");
					mv.addObject("flag",false);
					mv.setViewName("login");
					return mv;
				}
			}
			else if(username.startsWith("EMP") && username.length()==6)
			{
				try
				{
				employee=employeeDAO.findById(Integer.parseInt(username.substring(3))).get();
				}
				catch(Exception e)
				{
					mv.addObject("error", "Wrong Registration Id or Password !!");
					mv.addObject("flag",false);
					mv.setViewName("login");
					return mv;
				}
				
				if(employee!=null && employee.getPassword().equals(password))
				{
					session.setAttribute("username",username );
					session.setAttribute("uname", employee.getName().getFname()+" "+employee.getName().getLname());
					
					mv.addObject("teacher", employee);
					mv.addObject("success", "Welcome "+employee.getName().getFname()+", you are logged in !!");
					mv.addObject("flag",true);
					mv.setViewName("teacherpage");
					return mv;
				}
				else
				{
					mv.addObject("error", "Wrong Registration Id or Password !!");
					mv.addObject("flag",false);
					mv.setViewName("login");
					return mv;
				}
					
			}
			else
			{
				mv.addObject("error", "Invalid Registration ID !!");
				mv.addObject("flag",false);
				mv.setViewName("login");
				return mv;
			}
		}
		else
		{
			mv.addObject("error", "Enter Credentials !!");
			mv.addObject("flag",false);
			mv.setViewName("login");
			return mv;
		}
	}
	//login request above
	
	
	//register request below
	@RequestMapping(value = "/signup",method=RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("name", "Sign Up");
		mv.setViewName("register");
		return mv;
	}
	
	@GetMapping("/signup/verify")
	public ModelAndView verifyUser(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Student stu=null;
		Employee emp=null;
		String regid=req.getParameter("regid");
		
		if(regid!=null && !regid.equals(""))
		{
			if(regid.startsWith("STU") && regid.length()==6)
			{
				try
				{
					stu=studentDAO.findById(Integer.parseInt(regid.substring(3))).get();
				}
				catch(Exception e)
				{
					mv.addObject("error", "Enter Valid Registration ID !!");
					mv.addObject("err", false);
					mv.setViewName("register");
					return mv;
				}
				
				if(stu.getPassword()!=null)
				{
					mv.addObject("success","You are already registered, Please Sign In !!");
					mv.addObject("err", true);
					mv.addObject("regid", regid);
					mv.addObject("student", stu);
					mv.setViewName("register");
					return mv;
				}
				
				mv.addObject("isVerified", true);
				mv.addObject("flag", true);
				mv.addObject("success","Welcome, Successfully Verified. Please set your password ");
				mv.addObject("err", true);
				mv.addObject("regid", regid);
				mv.addObject("student", stu);
				mv.setViewName("register");
			}
			else if(regid.startsWith("EMP") && regid.length()==6)
			{
				try
				{
					emp=employeeDAO.findById(Integer.parseInt(regid.substring(3))).get();
				}
				catch(Exception e)
				{
					mv.addObject("error", "Enter Valid Registration ID !!");
					mv.addObject("err", false);
					mv.setViewName("register");
					return mv;
				}
				
				mv.addObject("course1",coursesDAO.findById(emp.getCourse_id1()).get().getC_name());
				mv.addObject("course2",coursesDAO.findById(emp.getCourse_id2()).get().getC_name());
				
				mv.addObject("isVerified", true);
				mv.addObject("success","Welcome, Successfully Verified. Please set your password ");
				mv.addObject("err", true);
				mv.addObject("regid", regid);
				mv.addObject("flag", false);
				mv.addObject("employee", emp);
				mv.setViewName("register");
			}
			else
			{
				mv.addObject("error", "Enter Valid Registration ID !!");
				mv.addObject("err", false);
				mv.setViewName("register");
			}
		}
		else
		{
			mv.addObject("error", "Enter Valid Registration ID !!");
			mv.addObject("err", false);
			mv.setViewName("register");
		}
		return mv;
	} 
	
	@PostMapping("/signup")
	public ModelAndView registerUser(HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		
		Student stu=null;
		Employee emp=null;
		
		String password=req.getParameter("password");
		String conPassword=req.getParameter("conpassword");
		
		String regid=req.getParameter("regid");
		
		if(regid.startsWith("STU") && regid.length()==6)
		{
				stu=studentDAO.findById(Integer.parseInt(regid.substring(3))).get();
				if(password.equals(conPassword) && password.length()<=10)
				{
					stu.setPassword(password);
					stu.setConPassword(conPassword);
					
					mv.addObject("flag", true);
					mv.addObject("success","Successfully registered !!");
					mv.setViewName("login");
					
					studentDAO.save(stu);
				}
				else
				{
					mv.addObject("isVerified", true);
					mv.addObject("flag", true);
					mv.addObject("error","Password and Confirm password not matches !!");
					mv.addObject("err", false);
					mv.addObject("regid", regid);
					mv.addObject("student", stu);
					mv.setViewName("register");
				}
				
		}
		else if(regid.startsWith("EMP") && regid.length()==6)
		{
			emp=employeeDAO.findById(Integer.parseInt(regid.substring(3))).get();
			if(password.equals(conPassword) && password.length()<=10)
			{
				emp.setPassword(password);
				emp.setConPassword(conPassword);
				mv.addObject("flag", true);
				mv.addObject("success","Successfully registered !!");
				mv.setViewName("login");
				
				employeeDAO.save(emp);
			}
			else
			{
				mv.addObject("isVerified", true);
				mv.addObject("flag", true);
				mv.addObject("error","Password and Confirm password not matches !!");
				mv.addObject("err", false);
				mv.addObject("regid", regid);
				mv.addObject("employee", emp);
				mv.setViewName("register");
			}
		}
		return mv;
	}
	//register request above
	
	//logout request below
	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public ModelAndView logout(HttpServletRequest req) { 
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		
		if(!session.getAttribute("username").equals(""))
		{	
			session.setAttribute("uname", "");
			session.setAttribute("username","");
			mv.addObject("success", "You Have Successfully Logged Out !!");
			mv.addObject("flag", true);
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("msg", "First Log In !!");
		mv.setViewName("login");
		return mv;
	}
	//logout request above		
}
