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
public class Employee {
	@Id
	private int id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
 	List<Skill> skills =new ArrayList<Skill>();
	
}
