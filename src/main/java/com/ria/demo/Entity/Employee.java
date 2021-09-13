package com.ria.demo.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer empid;
	private Fullname name;
	private Integer dept_id;
	private Integer course_id1;
	private Integer course_id2;
	private Date dob;
	private Date joiningDate;
	private String email;
	private String password;
	private String conPassword;
	
}
