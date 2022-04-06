package pl.kurs.java.testspringapp.service.stringCoder;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringForm;
import java.sql.Timestamp;

@Service
public class ToUpperCaseModStrImpl implements ModStr {
    @Override
    public StringForm modify(StringForm str) {
        return new StringForm(0, str.getStr(), str.getFunction(), str.getStr().toUpperCase(), 0,
                new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getMod() {
        return "To upper case";
    }
}
