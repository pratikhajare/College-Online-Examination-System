package com.ria.demo.Entity;

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
public class ResultLine implements Comparable<ResultLine>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer resLine_id;
	private Integer que_id;
	private String selAns;
	private Boolean isCorrect;
	private Integer marks;
	
	@Override
	public int compareTo(ResultLine o) {
		// TODO Auto-generated method stub
		return this.getQue_id()-o.getQue_id();
	}
	
}
