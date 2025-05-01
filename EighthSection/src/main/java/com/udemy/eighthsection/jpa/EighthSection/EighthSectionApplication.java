package com.udemy.eighthsection.jpa.EighthSection;

import java.util.List;

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
		List<Person> persons = (List<Person>) repository.findAll();
		
		persons.stream().forEach(person ->{
			System.out.println(person);
		});
	}

}
