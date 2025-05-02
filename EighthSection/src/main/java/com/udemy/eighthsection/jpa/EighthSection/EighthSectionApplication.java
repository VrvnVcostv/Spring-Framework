package com.udemy.eighthsection.jpa.EighthSection;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		findOne();

	}

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
