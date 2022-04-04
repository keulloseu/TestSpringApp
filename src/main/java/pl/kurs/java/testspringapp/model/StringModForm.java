package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringModForm {
    private int id;
    private String userString;
    private String function;
    private String modifiedString;
    private long time;
    private Timestamp timeOf;
}
