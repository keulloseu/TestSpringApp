package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.model.StringModRepo;

import java.sql.Timestamp;

@Repository
@RequiredArgsConstructor
public class JdbcStringModRepository implements StringModRepo {
    private final JdbcTemplate jdbcTemplate;

    public int save(StringModForm form) {
        return jdbcTemplate.update("insert into strings values (?,?,?,?,?,?)",
                null, form.getUserString(), form.getFunction(), form.getModifiedString(), Math.toIntExact(form.getTime()), new Timestamp(System.currentTimeMillis()));
    }
}
