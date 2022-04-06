package pl.kurs.java.testspringapp.model;

import java.util.List;

public interface StringRepo {
    int save(StringForm stringForm);

    List<StringForm> findAll();
    }
