package com.udemy.eighthsection.jpa.EighthSection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.eighthsection.jpa.EighthSection.dto.PersonDTO;
import com.udemy.eighthsection.jpa.EighthSection.entities.Person;
import com.udemy.eighthsection.jpa.EighthSection.repositories.PersonRepository;

@SpringBootApplication
public class EighthSectionApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EighthSectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List<Person> persons = (List<Person>) repository.findAll();
		// List<Person> persons = (List<Person>)
		// repository.findByProgrammingLanguageAndName("Java", "Maria");
		// persons.stream().forEach(person ->{
		// System.out.println(person);
		// });

		whereIn();

	}

	@Transactional(readOnly = true)
	public void customQuery() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=============================== Getting the name by Id ===============================");
		System.out.println("Give me the Id to get the name:");
		Long id = scanner.nextLong();
		scanner.close();
		String name = repository.getFullnameById(id);
		System.out
				.println("=============================== Showing the fullname by Id ===============================");
		System.out.println(name);
		System.out
				.println("=============================== Getting custom fields by Id ===============================");
		Object[] personReg = (Object[]) repository.obtenerPersonFullDataById(id);
		System.out.println("Id: " + personReg[0] + " Name: " + personReg[1] + " Lastname: " + personReg[2]
				+ " Programming Language: " + personReg[3]);
	}

	@Transactional(readOnly = true)
	public void customQuery2() {
		System.out.println(
				"=============================== List by Person and programming language ===============================");
		List<Object[]> personRegs = repository.findAllMixPersonDataList();

		personRegs.forEach(p -> {
			System.out.println("Programming language: " + p[1] + " and Person: " + p[0]);
		});

		System.out.println(
				"=============================== List by Person by custom instance ===============================");
		List<Person> persons = repository.findAllCustomPerson();
		persons.forEach(System.out::println);

		System.out.println(
				"=============================== List by PersonDTO by custom instance ===============================");
		List<PersonDTO> personDTO = repository.findAllCustomPersonDTO();
		personDTO.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void customQueryDistinct() {
		System.out.println("=============================== List by Person by names ===============================");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println(
				"=============================== List by Person distinct names ===============================");
		List<String> namesDistinct = repository.findAllNamesDistinct();
		namesDistinct.forEach(System.out::println);

		System.out.println(
				"=============================== List distincts Programming Languages ===============================");
		List<String> laguagesDistinct = repository.findAllProgrammingLanguageDistinct();
		laguagesDistinct.forEach(System.out::println);

		System.out.println(
				"=============================== Count distincts Programming Languages ===============================");
		Long total = repository.findAllProgrammingLanguageDistinctCount();
		System.out.println("Programming languages total: " + total);
	}

	@Transactional(readOnly = true)
	public void customQueryConcatUpperLower() {
		System.out.println("=============================== List by Fullnames ===============================");
		List<String> fullnames = repository.findAllFullnamePipe();
		fullnames.forEach(System.out::println);

		System.out.println("=============================== List by Fullnames ===============================");
		List<String> upper = repository.findAllFullnameConcatUpper();
		upper.forEach(System.out::println);

		System.out.println("=============================== List by Fullnames ===============================");
		List<String> lower = repository.findAllFullnameConcatLower();
		lower.forEach(System.out::println);

		System.out.println("=============================== List by Fullnames ===============================");
		List<Object[]> fullCase = repository.findAllPersonDataListCase();
		fullCase.forEach(p -> System.out
				.println("id= " + p[0] + " name= " + p[1] + " fullname= " + p[2] + " language= " + p[3]));
	}

	@Transactional(readOnly = true)
	public void customQueryBetween() {
		System.out.println("=============================== List by Id ranges ===============================");
		List<Person> persons = repository.findAllBetweenId(2L, 5L);
		persons.forEach(System.out::println);

		System.out.println("=============================== List by Name ranges ===============================");
		List<Person> personsNames = repository.findAllBetweenName("A", "J");
		personsNames.forEach(System.out::println);

		System.out.println(
				"=============================== List by Id ranges not custom ===============================");
		List<Person> personsNotCustom = repository.findAllBetweenName("A", "J");
		personsNotCustom.forEach(System.out::println);

		System.out.println(
				"=============================== List by Name ranges  not custom ===============================");
		List<Person> personsNamesNotCustom = repository.findAllBetweenName("A", "J");
		personsNamesNotCustom.forEach(System.out::println);

		System.out.println(
				"=============================== List by Name ranges and Order ===============================");
		List<Person> personsNamesOrdered = repository.findAllBetweenNameOrdered("A", "Z");
		personsNamesOrdered.forEach(System.out::println);

	}

	@Transactional(readOnly = true)
	public void customQueryBetween2() {
		System.out.println("=============================== List by Id ranges ===============================");
		List<Person> persons = repository.findAllBetweenId(2L, 5L);
		persons.forEach(System.out::println);

		persons = repository.getAllOrdered();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void customQueryWithAggregationFunctions() {
		System.out.println("=============================== Aggregation Functions ===============================");
		Long total = repository.totalPerson();
		System.out.println(total);

		System.out.println("=============================== Aggregation Functions ===============================");
		Long max = repository.maxId();
		System.out.println(max);

		System.out.println("=============================== Aggregation Functions ===============================");
		Long min = repository.minId();
		System.out.println(min);

		System.out.println("=============================== Names length ===============================");
		List<Object[]> length = repository.getPersonNameLenght();
		length.forEach(n -> {
			System.out.println(n[0]);
		});

		System.out.println("=============================== Max name length ===============================");
		Long maxLength = repository.getMaxNameLength();
		System.out.println(maxLength);

		System.out.println("=============================== Min name length ===============================");
		Long minLength = repository.getMinNameLength();
		System.out.println(minLength);
		
		System.out.println("=============================== Aggregation Function resume ===============================");
		Object[] resumeReg = (Object[]) repository.getResumeAggregationFunction();
		System.out.println("Min: " + resumeReg[0] + " Max: " + resumeReg[1] + " Sum: " + resumeReg[2] + " Avg: " + resumeReg[3] + " Count: " + resumeReg[4]);

	}

	@Transactional(readOnly = true)
	public void subQueries() {
		System.out.println("=============================== Query by shorter name ===============================");
		List<Object[]> register = repository.getShorterName();
		register.forEach(r -> {
			System.out.println("name: " + r[0] + " length: " + r[1]);
		});

		System.out.println("=============================== Query by longest name ===============================");
		register = repository.getLongestName();
		register.forEach(r -> {
			System.out.println("name: " + r[0] + " length: " + r[1]);
		});

	}

	@Transactional(readOnly = true)
	public void whereIn() {
		System.out.println("=============================== Where in ===============================");
		List<Person> register = repository.getPersonsById(Arrays.asList(1L,4L,7L,9L));
		register.forEach(System.out::println);
	}

	

	@Transactional
	public void delete() {
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the ID of the field you want to delete");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional
	public void delete2() {
		repository.findAll().forEach(System.out::println);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the ID of the field you want to delete");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(repository::delete,
				() -> System.out.println("Sorry, there's no person with ID: " + id));

		repository.findAll().forEach(System.out::println);
		scanner.close();
	}

	@Transactional
	public void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the ID of the field you want to modify");
		Long id = scanner.nextLong();
		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresent(person -> {
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
	public void create() {
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
	public void findOne() {
		// Person person = null;
		// Optional<Person> optinalPerson = repository.findById(1L);
		// if(optinalPerson.isPresent()){
		// person = optinalPerson.get();
		// }
		// repository.findById(2L).orElseThrow();
		// System.out.println(person);
		repository.findOne(1L).ifPresent(System.out::println);
		repository.findByNameContaining("ria").ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void list() {
		List<Object[]> data = repository.obtenerPersonData();
		data.stream().forEach(d -> {
			System.out.println(d[0] + " es experto en " + d[1]);
		});
		System.out.println("-----------------");
		List<Object[]> data2 = repository.obtenerPersonData("María", "Java");
		data2.stream().forEach(d -> {
			System.out.println(d[0] + " es experto en " + d[1]);
		});
	}

}
