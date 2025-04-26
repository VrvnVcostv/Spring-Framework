package com.udemy.thirdsection.invoice.ThirdSection.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Invoice {


    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
    @Qualifier("default")
    private List<Item> items; 
    
    @PostConstruct
    public void init(){
        System.out.println("Creando el compoente de la factura");
        client.setName(client.getName().concat(" Pepe"));
        description = description.concat(" of the client: ").concat(client.getName().concat(" ").concat(client.getLastname()));

    }

    public int getTotal(){
        int total = 0;
        for (Item item : items) {
            total += item.getAmount();
        }
        // int total = items.stream()
        // .map(item -> item.getAmount())
        // .reduce(0,(sum,amount) -> sum + amount);
        return total;
    }
}
