package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.model.StringModRepo;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcStringModRepository implements StringModRepo {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(StringModForm form) {
        return jdbcTemplate.update("insert into strings values (?,?,?,?,?,?)",
                null, form.getUserString(), form.getFunction(), form.getModifiedString(), Math.toIntExact(form.getTime()), form.getTimeOf());
    }

    @Override
    public List<StringModForm> findAll() {
        return jdbcTemplate.query("select * from strings", new BeanPropertyRowMapper<>(StringModForm.class));
    }
}
