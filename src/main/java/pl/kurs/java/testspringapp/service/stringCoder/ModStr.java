package pl.kurs.java.testspringapp.service.stringCoder;

import pl.kurs.java.testspringapp.model.StringForm;

public interface ModStr {
    StringForm modify(StringForm str);

    String getMod();
}
