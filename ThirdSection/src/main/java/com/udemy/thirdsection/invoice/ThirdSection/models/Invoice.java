package com.udemy.thirdsection.invoice.ThirdSection.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private String description;
    private List<Item> items; 
}
