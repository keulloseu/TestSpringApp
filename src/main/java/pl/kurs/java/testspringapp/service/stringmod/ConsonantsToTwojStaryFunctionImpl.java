package pl.kurs.java.testspringapp.service.stringmod;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;

@Service
public class ConsonantsToTwojStaryFunctionImpl implements Function {
    @Override
    public StringModForm modify(StringModForm form) {
        return new StringModForm(form.getUserString(), form.getFunction(), form.getUserString().replaceAll("[bcdfghjklmnpqrstvwxy]", " twoj stary "), 0);
    }

    @Override
    public String getSymbol() {
        return "all consonants to 'twoj stary'";
    }
}
