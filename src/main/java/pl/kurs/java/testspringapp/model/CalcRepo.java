package pl.kurs.java.testspringapp.model;

import java.sql.Timestamp;

public interface CalcRepo {

    int save(CalcForm calcForm);
}
