package pl.kurs.java.testspringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.CalculationForm;
import pl.kurs.java.testspringapp.model.CalculationRepo;

import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
public class JdbcCalculationRepo implements CalculationRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public double save(CalculationForm calculationForm) throws SQLException {
        return jdbcTemplate.update("INSERT INTO CALCULATION VALUES (?, ?, ?, ?, ?)",
                calculationForm.getFirstNumber(),
                calculationForm.getSecondNumber(),
                calculationForm.getMathSymbols(),
                calculationForm.getResult(),
                new Timestamp(System.currentTimeMillis()));
    }
}
