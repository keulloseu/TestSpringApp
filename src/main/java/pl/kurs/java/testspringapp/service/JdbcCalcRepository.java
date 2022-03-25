package pl.kurs.java.testspringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;

import java.sql.Timestamp;

@Repository
public class JdbcCalcRepository implements CalcRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(CalcForm calcForm) {
        return jdbcTemplate.update("insert into calculation values (?,?,?,?,?)",
                calcForm.getFirstArgument(), calcForm.getSecondArgument(), calcForm.getOperator(), calcForm.getResult(), new Timestamp(System.currentTimeMillis()));
    }
}
