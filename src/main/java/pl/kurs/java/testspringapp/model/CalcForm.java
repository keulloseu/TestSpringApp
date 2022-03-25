package pl.kurs.java.testspringapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcForm {
    private Double firstArgument;
    private Double secondArgument;
    private String operator;
    private Double result;
}
