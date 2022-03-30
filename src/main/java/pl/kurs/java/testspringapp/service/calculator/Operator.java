package pl.kurs.java.testspringapp.service.calculator;

public interface Operator {
    double calculate(double num1, double num2);

    String getSymbol();
}
