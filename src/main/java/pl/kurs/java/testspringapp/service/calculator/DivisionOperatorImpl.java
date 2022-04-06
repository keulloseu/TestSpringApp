package pl.kurs.java.testspringapp.service.calculator;

import org.springframework.stereotype.Service;

@Service
public class DivisionOperatorImpl implements Operator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public String getSymbol() {
        return "/";
    }

}
