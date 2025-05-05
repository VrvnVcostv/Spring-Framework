package com.udemy.ninthsection.jpa.NinthSection;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.ninthsection.jpa.NinthSection.entities.Address;
import com.udemy.ninthsection.jpa.NinthSection.entities.Client;
import com.udemy.ninthsection.jpa.NinthSection.entities.ClientDetails;
import com.udemy.ninthsection.jpa.NinthSection.entities.Course;
import com.udemy.ninthsection.jpa.NinthSection.entities.Invoice;
import com.udemy.ninthsection.jpa.NinthSection.entities.Student;
import com.udemy.ninthsection.jpa.NinthSection.repositories.ClientDetailsRepository;
import com.udemy.ninthsection.jpa.NinthSection.repositories.ClientRepository;
import com.udemy.ninthsection.jpa.NinthSection.repositories.InvoiceRepository;
import com.udemy.ninthsection.jpa.NinthSection.repositories.StudentRepository;

@SpringBootApplication
public class NinthSectionApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientDetailsRepository clientDetailsRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(NinthSectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToMany();
	}

	@Transactional
	public void manyToMany() {
		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso Java Master", "Andres");
		Course course2 = new Course("Curso Spring Master", "Andres");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1,student2));
		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void oneToOneBidirectional() {
		Client client = new Client("Erba", "Pura");
		ClientDetails clientDetails = new ClientDetails(true, 5000);

		client.setClientDetails(clientDetails);
		clientDetails.setClient(client);	
			
		clientRepository.save(client);
		
		System.out.println(client);
	}

	@Transactional
	public void oneToOneFindById() {
		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);
		Optional<Client> client = clientRepository.findById(2L);
		client.ifPresent(c -> {
			c.setClientDetails(clientDetails);
			clientRepository.save(c);
			System.out.println(c);
		});

	}

	@Transactional
	public void oneToOne() {
		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);
		Client client = new Client("Erba", "Pura");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);
		System.out.println(client);
	}

	@Transactional
	public void removeInvoiceBidirectional() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("House stuff", 5000L);
		Invoice invoice2 = new Invoice("Gardening stuff", 2500L);

		client.addInvoices(invoice1, invoice2);

		System.out.println(clientRepository.save(client));

		Optional<Client> optionalClient2 = clientRepository.findOne(3L);
		optionalClient2.ifPresent(c -> {
			Invoice invoice3 = new Invoice("House stuff", 5000L);
			invoice3.setId(1L);
			Optional<Invoice> optionalInvoice = Optional.of(invoice3);
			optionalInvoice.ifPresent(invoice -> {
				c.removeInvoices(invoice);
				clientRepository.save(c);
				System.out.println(c);
			});
		});
	}

	@Transactional
	public void oneToManyRemoveAddressFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);
		optionalClient.ifPresent(client -> {
			Invoice invoice1 = new Invoice("House stuff", 5000L);
			Invoice invoice2 = new Invoice("Gardening stuff", 2500L);

			client.addInvoices(invoice1, invoice2);

			System.out.println(clientRepository.save(client));

			Optional<Client> optionalClient2 = clientRepository.findOne(1L);
			optionalClient2.ifPresent(c -> {
				Optional<Invoice> optionalInvoice = invoiceRepository.findById(2L);
				optionalInvoice.ifPresent(invoice -> {
					c.removeInvoices(invoice);
					clientRepository.save(c);
					System.out.println(c);
				});
			});
		});
	}

	@Transactional
	public void oneToManyBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);
		optionalClient.ifPresent(client -> {
			Invoice invoice1 = new Invoice("House stuff", 5000L);
			Invoice invoice2 = new Invoice("Gardening stuff", 2500L);

			client.addInvoices(invoice1, invoice2);

			System.out.println(clientRepository.save(client));
		});
	}

	@Transactional
	public void oneToManyBidireccional() {
		Client client = new Client("Fran", "Moraz");

		Invoice invoice1 = new Invoice("House stuff", 5000L);
		Invoice invoice2 = new Invoice("Gardening stuff", 2500L);

		client.addInvoices(invoice1, invoice2);

		System.out.println(clientRepository.save(client));
	}

	@Transactional
	public void removeAddressFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El vergel", 1234);
			Address address2 = new Address("Vasco de Gama", 9875);

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);
			clientRepository.save(client);

			System.out.println(client);

			Optional<Client> optionalClient2 = clientRepository.findOneAddresses(2L);
			optionalClient2.ifPresent(c -> {
				c.getAddresses().remove(address1);
				clientRepository.save(c);
				System.out.println(c);
			});
		});
	}

	@Transactional
	public void removeAddress() {
		Client client = new Client("Fran", "Moraz");

		Address address1 = new Address("El Verjel", 1234);
		Address address2 = new Address("Vasco de Gama", 9875);

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		System.out.println(clientRepository.save(client));

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(address1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void manyToOne() {
		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Office stuff", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

	@Transactional
	public void oneToMany() {
		Client client = new Client("Fran", "Moraz");
		Address address1 = new Address("El Verjel", 1234);
		Address address2 = new Address("Vasco de Gama", 9875);
		client.getAddresses().add(address1);
		client.getAddresses().add(address2);
		System.out.println(clientRepository.save(client));
	}

	@Transactional
	public void oneToManyFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			Address address1 = new Address("El Verjel", 1234);
			Address address2 = new Address("Vasco de Gama", 9875);
			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);
			System.out.println(clientRepository.save(client));
		}
	}

	@Transactional
	public void manyToOneFindClientById() {
		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();

			Invoice invoice = new Invoice("Office stuff", 2000L);
			invoice.setClient(client);
			Invoice invoiceDb = invoiceRepository.save(invoice);
			System.out.println(invoiceDb);
		}
	}

}
