package pl.kurs.java.testspringapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.Scanner;

@Configuration
public class BeanConfig {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public StringModForm getStringModForm() {
        return new StringModForm();
    }
}
