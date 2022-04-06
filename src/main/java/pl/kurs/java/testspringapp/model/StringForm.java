package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringForm {
    private String text;
    private String stringOperator;
    private String result;
}
