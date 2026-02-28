package org.dibya.project.rest.api.currency_converter;

import org.dibya.project.rest.api.currency_converter.service.CurrencyConverterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CurrencyConverterConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
