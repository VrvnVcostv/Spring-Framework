package com.udemy.thirdsection.invoice.ThirdSection.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequestScope
// @JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {


    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;
    @Autowired
    @Qualifier("default")
    private List<Item> items; 
    
    @PostConstruct
    public void onInit(){
        System.out.println("Creating invoice component");
        client.setName(client.getName().concat(" Pepe"));
        description = description.concat(" of the client: ").concat(client.getName().concat(" ").concat(client.getLastname()));
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("Destroying invoice component");
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
