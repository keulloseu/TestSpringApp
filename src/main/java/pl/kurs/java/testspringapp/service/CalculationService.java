package pl.kurs.java.testspringapp.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.CalculationForm;

@NoArgsConstructor
@Service
public class CalculationService {

    public double calculateOperation(CalculationForm calculationForm) {
        switch (calculationForm.getMathSymbols()) {
            case "+":
                return calculationForm.getFirstNumber() + calculationForm.getSecondNumber();
            case "-":
                return calculationForm.getFirstNumber() - calculationForm.getSecondNumber();
            case "*":
                return calculationForm.getFirstNumber() * calculationForm.getSecondNumber();
            case "/":
                return calculationForm.getFirstNumber() / calculationForm.getSecondNumber();
            case "^":
                return Math.pow(calculationForm.getFirstNumber(), calculationForm.getSecondNumber());
            case "root":
                return Math.pow(calculationForm.getFirstNumber(), 1 / calculationForm.getSecondNumber());
            default:
                System.exit(1);
                return 1;
        }
    }
}
