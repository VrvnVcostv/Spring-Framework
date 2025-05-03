package com.udemy.ninthsection.jpa.NinthSection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.ninthsection.jpa.NinthSection.entities.Address;
import com.udemy.ninthsection.jpa.NinthSection.entities.Client;
import com.udemy.ninthsection.jpa.NinthSection.entities.Invoice;
import com.udemy.ninthsection.jpa.NinthSection.repositories.ClientRepository;
import com.udemy.ninthsection.jpa.NinthSection.repositories.InvoiceRepository;

@SpringBootApplication
public class NinthSectionApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(NinthSectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToMany();
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
