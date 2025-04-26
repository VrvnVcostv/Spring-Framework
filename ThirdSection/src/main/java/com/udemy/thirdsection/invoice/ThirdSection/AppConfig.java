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
    @PropertySource(value = "classpath:data.properties")
})
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        Product p1 = new Product("Sony Camera",800);
        Product p2 = new Product("Bicycle",26);
        Product p3 = new Product("Wifi Router",99);
        return Arrays.asList(new Item(p1,2), new Item(p2,5), new Item(p3,7));
    }
}
