package pl.kurs.java.testspringapp.service;

public class CalcService {
    public Double calcResult(double a, double b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case  "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0d;
        }
    }
}
