package pl.kurs.java.testspringapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kurs.java.testspringapp.model.StringForm;

import java.util.Scanner;

@Configuration
public class BeanConfig {
    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public StringForm getStringForm() {
        return new StringForm();
    }
}
