package com.learnspring.ini;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {

	@Id
	private int id;
	
	private String name;
	
	//@OneToOne
	//private Student student; 
}
