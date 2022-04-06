package pl.kurs.java.testspringapp.service.calculator;

import org.springframework.stereotype.Service;

@Service
public class RootOperatorImpl implements Operator {
    @Override
    public double calculate(double num1, double num2) {
        return Math.pow(num1, 1 / num2);
    }

    @Override
    public String getSymbol() {
        return "root";
    }

}