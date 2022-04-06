package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcStringRepo implements StringRepo {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int save(StringForm stringForm) {
        return jdbcTemplate.update("insert into strings values (?,?,?,?,?,?)",
                null, stringForm.getStr(), stringForm.getFunction(), stringForm.getModStr(),
                Math.toIntExact(stringForm.getTime()), stringForm.getTimeOf());
    }

    @Override
    public List<StringForm> findAll() {
        return jdbcTemplate.query("select * from strings", new BeanPropertyRowMapper<>(StringForm.class));
    }
}
