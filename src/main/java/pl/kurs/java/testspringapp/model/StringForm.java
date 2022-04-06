package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StringForm {
    private int id;
    private String str;
    private String function;
    private String modStr;
    private long time;
    private Timestamp timeOf;
}
