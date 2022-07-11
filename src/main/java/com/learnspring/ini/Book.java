package com.learnspring.ini;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value="book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

	private int id;
	private String name;
	private String author;
}
