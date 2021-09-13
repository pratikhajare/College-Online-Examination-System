package com.ria.demo.Entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Fullname {
	private String fname;
	private String mname;
	private String lname;
}
