package com.udemy.thirdsection.invoice.ThirdSection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.udemy.thirdsection.invoice.ThirdSection.models.Item;
import com.udemy.thirdsection.invoice.ThirdSection.models.Product;

import java.util.List;
import java.util.Arrays;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
})
public class AppConfig {

    //@Primary
    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Sony Camera",800);
        Product p2 = new Product("Bicycle",26);
        Product p3 = new Product("Sport shoes",99);
        return Arrays.asList(new Item(p1,2), new Item(p2,5), new Item(p3,7));
    }

    @Bean("default") // To make the change without modifying too much code, you can either use the @Primary annotation or set a bean as the ("default").
    List<Item> itemsInvoiceOfOffice(){
        Product p1 = new Product("Monitor",200);
        Product p2 = new Product("Chair",400);
        Product p3 = new Product("Desk",100);
        Product p4 = new Product("Lamp",29);
        Product p5 = new Product("PC",399);
        return Arrays.asList(new Item(p1,2), new Item(p2,5), new Item(p3,7), new Item(p4,3), new Item(p5,1));
    }
}
