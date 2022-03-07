package com.coderhouse.desafio2.java.orm;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_writer")

public class Writer {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "int_id")
	    private Integer id;

	    @Column(name = "str_name")
	    private String name;
	    
	    @Column(name ="int_age")
	    private Integer Age;
	    
	    @OneToMany(mappedBy= "writer")
	    private List <Book>   bookList;
	    

		public Integer getAge() {
			return Age;
		}

		public void setAge(Integer age) {
			Age = age;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		

		public List<Book> getBookList() {
			return bookList;
		}

		public void setBookList(List<Book> bookList) {
			this.bookList = bookList;
		}

		public Writer() {
			
		}

	  

}
