package com.udemy.eighthsection.jpa.EighthSection;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eighthsection.jpa.EighthSection.entities.Person;
import com.udemy.eighthsection.jpa.EighthSection.repositories.PersonRepository;

@SpringBootApplication
public class EighthSectionApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EighthSectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Maria");
		// persons.stream().forEach(person ->{
		// 	System.out.println(person);
		// });

		delete();

	}

	@Transactional
	public void delete(){
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the ID of the field you want to delete");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the ID of the field you want to modify");
		Long id = scanner.nextLong();
		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresent(person ->{
			System.out.println("Person finded:");
			System.out.println(person);
			System.out.println("Insert programming language:");
			String programLanguage = scanner.next();
			person.setProgrammingLanguage(programLanguage);
			Person newPerson = repository.save(person);
			System.out.println("Person finded with modification:");
			System.out.println(newPerson);
		});
		scanner.close();
	}

	@Transactional
	public void create(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me name:");
		String name = scanner.next();
		System.out.println("Give me lastname:");
		String lastname = scanner.next();
		System.out.println("Give me programming language:");
		String programmingLanguage = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);

		Person newPerson = repository.save(person);
		
		repository.findById(newPerson.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne(){
		// Person person = null;
		// Optional<Person> optinalPerson = repository.findById(1L);
		// if(optinalPerson.isPresent()){
		// 	person = optinalPerson.get();
		// }
		// repository.findById(2L).orElseThrow();
		// System.out.println(person);
		repository.findOne(1L).ifPresent(System.out::println);
		repository.findByNameContaining("ria").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void list(){
		List<Object[]> data = repository.obtenerPersonData();
		data.stream().forEach(d ->{
			System.out.println(d[0] + " es experto en " + d[1]);
		});
		System.out.println("-----------------");
		List<Object[]> data2 = repository.obtenerPersonData("María", "Java");
		data2.stream().forEach(d ->{
			System.out.println(d[0] + " es experto en " + d[1]);
		});
	}

}
