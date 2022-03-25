package pl.kurs.java.testspringapp.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public CalcService() {
    }

    public Double calculateResult(Double firstArgument, Double secondArgument, String operator) {
        switch (operator) {
            case "+":
                return firstArgument + secondArgument;
            case "-":
                return firstArgument - secondArgument;
            case "*":
                return firstArgument * secondArgument;
            case "/":
                return firstArgument / secondArgument;
            case "^":
                return Math.pow(firstArgument, secondArgument);
            case "root":
                return Math.pow(firstArgument, 1 / secondArgument);
            default:
                return 0D;
        }
    }
}
