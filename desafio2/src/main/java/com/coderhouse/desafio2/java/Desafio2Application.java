package com.coderhouse.desafio2.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.desafio2.java.orm.Book;
import com.coderhouse.desafio2.java.orm.BookRepository;
import com.coderhouse.desafio2.java.orm.Category;
import com.coderhouse.desafio2.java.orm.CategoryRepository;
import com.coderhouse.desafio2.java.orm.Editorial;
import com.coderhouse.desafio2.java.orm.EditorialRepository;
import com.coderhouse.desafio2.java.orm.Writer;
import com.coderhouse.desafio2.java.orm.WriterRepository;

import java.util.*;

@SpringBootApplication
public class Desafio2Application implements CommandLineRunner{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private WriterRepository writerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private EditorialRepository editorialRepository;

	public static void main(String[] args) {		
		SpringApplication.run(Desafio2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.insertData();
		this.selectData();
		this.filterData();
		
		
	}
	
	private void insertData() {
		
		Category category= new Category();
		category.setName("Fantasy");
		
		 this.categoryRepository.saveAndFlush(category);

		Editorial editorial= new Editorial();
		editorial.setName("San Marco");
		
		 this.editorialRepository.saveAndFlush(editorial);

		
		Writer writer = new Writer();
		writer.setName("Jona Leders");
		writer.setAge(28);
		
		Writer persistedWriter = this.writerRepository.saveAndFlush(writer);
		
		
		Book book = new Book();
		book.setName("The lord of the rings");
		book.setWriter(writer);
		book.setCategory(category);
		book.setEditorial(editorial);
		
		this.bookRepository.save(book);
		
		System.out.printf("System has added a record in 'tbl_writer' table with id %d %n", persistedWriter.getId());
		
		
		writer = new Writer();
		writer.setName("Miguel Angelo");
		writer.setAge(72);
		
		this.writerRepository.saveAndFlush(writer);
		
		book = new Book();
		book.setName("Harry Potter");
		book.setWriter(writer);
		book.setCategory(category);
		book.setEditorial(editorial);
		
		this.bookRepository.save(book);
		
		persistedWriter = this.writerRepository.saveAndFlush(writer);
		
		System.out.printf("System has added a record in 'tbl_writer' table with id %d %n", persistedWriter.getId());
		
		
	}
	private void selectData() {
		System.out.println("System has to show some records from table 'writer'");
		List <Writer> writerList =this.writerRepository.findAll();
		for (Writer writer:writerList) {
			System.out.printf("Record id: %d with name %s and age %d in 'writer' table %n", writer.getId(),writer.getName(),writer.getAge());
		}
	}
	private void filterData() {
		
		List<Book> filterByName=this.bookRepository.filtered("The lord of the rings");
		System.out.println("System has to show some records from table 'Book' filtered by Name");
		for (Book book:filterByName) {
			System.out.printf("Record id: %id with name %s in 'Book' table %n", book.getId(),book.getWriter());
		}
		
	}
}
