package com.udemy.thirdsection.invoice.ThirdSection.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Client {
    private String name;
    private String lastname;
}
