package com.ria.demo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stud_id;
	private Fullname name;
	private Integer dept_id;
	private Integer year;
	private String division;
	private Integer rollno;
	private String email;
	private String password;
	private String conPassword;
	private Date dob;
	private Boolean isAvailableExam;
	
}
