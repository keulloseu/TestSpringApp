package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;

import java.sql.Timestamp;
import java.util.Scanner;

@Repository
@RequiredArgsConstructor
public class JdbcCalcRepository implements CalcRepo {
    private final JdbcTemplate jdbcTemplate;
    private final Scanner scanner;

    public int save(CalcForm form) {
        return jdbcTemplate.update("insert into calculator values (?,?,?,?,?)",
                form.getFirstArgument(), form.getSecondArgument(), form.getOperator(), form.getResult(), new Timestamp(System.currentTimeMillis()));
    }
}
