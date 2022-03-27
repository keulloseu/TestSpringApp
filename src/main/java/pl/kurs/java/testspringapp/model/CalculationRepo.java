package pl.kurs.java.testspringapp.model;

import java.sql.SQLException;

public interface CalculationRepo {
   double save(CalculationForm calculationForm) throws SQLException;
}
