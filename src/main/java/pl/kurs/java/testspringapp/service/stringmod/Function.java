package pl.kurs.java.testspringapp.service.stringmod;

import pl.kurs.java.testspringapp.model.StringModForm;

public interface Function {

    StringModForm modify(StringModForm form);

    String getSymbol();
}
