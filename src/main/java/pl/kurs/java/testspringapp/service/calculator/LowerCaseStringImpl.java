package pl.kurs.java.testspringapp.service.calculator;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LowerCaseStringImpl implements StringOperator {
    @Override
    public String convert(String text) {
        return text.toLowerCase();
    }

    @Override
    public String getOperation() {
        return "Lower Case";
    }
}
