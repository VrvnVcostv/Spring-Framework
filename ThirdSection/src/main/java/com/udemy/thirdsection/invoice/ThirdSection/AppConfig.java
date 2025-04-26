package com.udemy.thirdsection.invoice.ThirdSection;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:data.properties")
})
public class AppConfig {

}
