package com.udemy.thirdsection.invoice.ThirdSection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.thirdsection.invoice.ThirdSection.models.Client;
import com.udemy.thirdsection.invoice.ThirdSection.models.Invoice;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show(){ 
        Invoice i = new Invoice();
        Client c = new Client();

        c.setLastname(invoice.getClient().getName());
        c.setName(invoice.getClient().getLastname());

        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());
        
        return i;
    } 
}
