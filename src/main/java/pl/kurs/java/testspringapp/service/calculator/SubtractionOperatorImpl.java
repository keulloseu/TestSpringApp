package pl.kurs.java.testspringapp.service.calculator;

import org.springframework.stereotype.Service;

@Service
public class SubtractionOperatorImpl implements Operator {
    @Override
    public Double calculate(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getName() {
        return "-";
    }
}

/*

napisz analogiczny c0ontroller do algorytmow stringa - czyli user podaje jaksi string, wybiera z DD algorytm szyfrujacy (np reverseCAse, reverseString, toUpperCAse...)
i uzyj facade do implementacji


------------------------


chcemy po kazdej wywolanej metodzie zapisac jej statystyki do bazy czyli np gosc uzywa dodawnaa, to do bazy zapisujemy:
czas wykonania, nazwa metody, argumenty, timestamp, ip
proigramowanie aspektowe (AoP)

------------------

dodac EP ktro umozliwi sciagniecei statystyk z bazy w formie csv

---------------

poczytac o repozytoriach JPA i Hibernate

 */