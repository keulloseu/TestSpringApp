package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationForm {
    private double firstNumber;
    private double secondNumber;
    private String mathSymbols;
    private double result;
}
