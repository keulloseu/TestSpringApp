package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;

import java.sql.Timestamp;

@Repository
@RequiredArgsConstructor
public class JdbcStringRepository implements StringRepo {
    private final JdbcTemplate jdbcTemplate;

    public int save(StringForm stringForm) {
        return jdbcTemplate.update("insert into string values (?,?,?,?)",
                stringForm.getText(),stringForm.getStringOperator(),stringForm.getResult(), new Timestamp(System.currentTimeMillis()));
    }
}
