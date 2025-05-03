package com.udemy.ninthsection.jpa.NinthSection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.ninthsection.jpa.NinthSection.entities.Client;
import com.udemy.ninthsection.jpa.NinthSection.entities.Invoice;
import com.udemy.ninthsection.jpa.NinthSection.repositories.ClientRepository;
import com.udemy.ninthsection.jpa.NinthSection.repositories.InvoiceRepository;

@SpringBootApplication
public class NinthSectionApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;


	public static void main(String[] args) {
		SpringApplication.run(NinthSectionApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		ManyToOne();
	}

	public void ManyToOne(){
		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Office stuff", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

}
