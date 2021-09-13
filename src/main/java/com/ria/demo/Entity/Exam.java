package com.ria.demo.Entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Exam {

	@Id
	 @GeneratedValue(strategy=GenerationType.TABLE)  
	private Integer exam_id;
	private String examname;
	private Integer courseid;
	private LocalDateTime dateOfCreation;
	private Date examdate;
	private Date dateValid;
	private LocalTime starttime;
	private LocalTime endTime;
	private Integer noOfQuestions;
	private Integer totalMarks;
	private Float duration;
	private Integer empid;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="exam_id")  
	List<Questions> questions;
}
