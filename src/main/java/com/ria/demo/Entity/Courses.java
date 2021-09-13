package com.ria.demo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer course_id;
	private String c_name;
	private Integer dept_id;
	private Integer year;
}
