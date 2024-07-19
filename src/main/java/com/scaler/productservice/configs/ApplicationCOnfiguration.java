package com.scaler.productservice.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.awt.geom.RectangularShape;
@Configuration
public class ApplicationCOnfiguration {


    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplateBuilder().build();
    }
}
