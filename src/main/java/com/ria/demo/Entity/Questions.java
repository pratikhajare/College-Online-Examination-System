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
@ToString
@AllArgsConstructor
public class Questions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private Integer que_id;

	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String correctAns;
	private Integer marks;
	
	
}
