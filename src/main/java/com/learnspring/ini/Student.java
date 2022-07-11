package com.learnspring.ini;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class Student {
	@Id
	private int id;
	
	@NonNull
	private int age;
	
	@NonNull
	private String fname;
	
	private String lname;
	private String gender;
	
	//@OneToOne(mappedBy = "student")
	//private Passport passport;
}
