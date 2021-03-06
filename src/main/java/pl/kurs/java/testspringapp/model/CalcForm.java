package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcForm {
    private Double firstArgument;
    private Double secondArgument;
    private Double result;
    private String operator;
}
