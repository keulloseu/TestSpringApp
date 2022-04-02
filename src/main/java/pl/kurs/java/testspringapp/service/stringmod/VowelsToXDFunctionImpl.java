package pl.kurs.java.testspringapp.service.stringmod;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;

@Service
public class VowelsToXDFunctionImpl implements Function {
    @Override
    public StringModForm modify(StringModForm form) {
        return new StringModForm(form.getUserString(), form.getFunction(), form.getUserString().replaceAll("[aeiou]", "XD"), 0);
    }

    @Override
    public String getSymbol() {
        return "all vowels to 'XD'";
    }
}
