package pl.kurs.java.testspringapp.model;

import java.util.List;

public interface StringModRepo {

    int save(StringModForm form);

    List<StringModForm> findAll();
}
