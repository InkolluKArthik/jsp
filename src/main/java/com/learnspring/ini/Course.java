package com.learnspring.ini;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	List<review> reviews=new ArrayList<review>();
}
