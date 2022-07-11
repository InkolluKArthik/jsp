package com.learnspring.ini;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	@Id
	private int id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="emp_skill",joinColumns = {@JoinColumn(name="skill_id")},inverseJoinColumns = {@JoinColumn(name="emp_id")})
	List<Employee> employees=new ArrayList<Employee>();
}

