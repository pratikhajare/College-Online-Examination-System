package com.ria.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Result {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer result_id;
	private Integer correctQuestions;
	private Integer studid;
	private Integer examid;
	private Integer gotMarks;
	private Boolean resStatus;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="result_id")
	List<ResultLine> resList;
}
