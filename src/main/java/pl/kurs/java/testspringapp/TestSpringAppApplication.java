package pl.kurs.java.testspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TestSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringAppApplication.class, args);
    }

}
