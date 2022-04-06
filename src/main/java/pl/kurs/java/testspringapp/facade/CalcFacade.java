package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.service.calculator.Operator;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalcFacade {
    private Map<String, Operator> allOperators;

    public CalcFacade(Set<Operator> operators) {
        allOperators = operators.stream().collect(Collectors.toMap(Operator::getSymbol, Function.identity()));
    }

    public Set<String> getOperatorSymbols() {
        return allOperators.keySet();
    }

    public double getResult(CalcForm form) {
        form.setResult(allOperators.get(form.getOperator()).calculate(form.getFirstArgument(), form.getSecondArgument())); //nie pewne tutaj jest problem
        return allOperators.get(form.getOperator()).calculate(form.getFirstArgument(), form.getSecondArgument());
    }

    @PostConstruct
    public void init() {
        System.out.println("Calcualtor facade ready to use with " + allOperators.keySet() + " operators");
    }
}
