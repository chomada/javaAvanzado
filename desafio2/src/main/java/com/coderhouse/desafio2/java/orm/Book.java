package com.coderhouse.desafio2.java.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")

public class Book {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "int_id")
	    private Integer id;

	    @Column(name = "str_name")
	    private String name;
	    
	    @ManyToOne
	    private Writer writer;
	    
	    @ManyToOne
	    private Category category;
	    
	    @ManyToOne
	    private Editorial editorial;
	    
	    

		public Editorial getEditorial() {
			return editorial;
		}

		public void setEditorial(Editorial editorial) {
			this.editorial = editorial;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Writer getWriter() {
			return writer;
		}

		public void setWriter(Writer writer) {
			this.writer = writer;
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

		public Book() {
			
		}

	   

//	    @OneToMany(mappedBy = "person")
//	    private List<Document> documentList;

}
