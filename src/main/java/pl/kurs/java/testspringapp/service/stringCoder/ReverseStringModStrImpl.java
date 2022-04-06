package pl.kurs.java.testspringapp.service.stringCoder;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringForm;

import java.sql.Timestamp;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReverseStringModStrImpl implements ModStr {
    @Override
    public StringForm modify(StringForm str) {
        return new StringForm(0, str.getStr(), str.getFunction() , Stream.of(str.getStr()).map(word ->
                new StringBuilder(word).reverse()).collect(Collectors.joining(" ")), 0,
                new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getMod() {
        return "Reverse string";
    }
}
