package pl.kurs.java.testspringapp.service.stringmod;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.sql.Timestamp;

@Service
public class VowelsToXDFunctionImpl implements Function {
    @Override
    public StringModForm modify(StringModForm form) {
        return new StringModForm(0, form.getUserString(), form.getFunction(), form.getUserString().replaceAll("(?i)[aeiouy]", "XD"), 0, new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getSymbol() {
        return "all vowels to 'XD'";
    }
}
