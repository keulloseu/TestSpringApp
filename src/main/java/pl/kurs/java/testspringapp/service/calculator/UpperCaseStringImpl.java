package pl.kurs.java.testspringapp.service.calculator;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UpperCaseStringImpl implements StringOperator {
    @Override
    public String convert(String text) {
        return text.toUpperCase();
    }

    @Override
    public String getOperation() {
        return "Upper Case";
    }


}
