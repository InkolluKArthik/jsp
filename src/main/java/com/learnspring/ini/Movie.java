package com.learnspring.ini;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

	@Id
	private int mid;
	
	private String name;
	private String director;
	private String length;
	private String producer;
	
	
	
	
}
