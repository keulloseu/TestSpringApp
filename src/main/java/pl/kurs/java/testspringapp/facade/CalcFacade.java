package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;
import pl.kurs.java.testspringapp.service.calculator.Operator;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalcFacade {
    private final Map<String, Operator> allOperators;
    private final CalcRepo calcRepo;

    public CalcFacade(Set<Operator> operators, CalcRepo calcRepo) {
        allOperators = operators.stream().collect(Collectors.toMap(Operator::getName, Function.identity()));
        this.calcRepo = calcRepo;
    }

    public Set<String> getOperatorSymbols() {
        return allOperators.keySet();
    }

    public void calculateResult(CalcForm form) {
        if (form.getFirstArgument() != null && form.getSecondArgument() != null) {
            form.setResult(allOperators.get(form.getOperator()).calculate(form.getFirstArgument(), form.getSecondArgument()));
        }
        calcRepo.save(form);
    }

    public String redirect(ModelMap map, @ModelAttribute("calcForm") CalcForm form) {
        map.addAttribute("result", form.getResult());
        map.addAttribute("calcForm", form);
        map.addAttribute("operators", getOperatorSymbols());
        return form.getResult() == null ? "calculator_redo" : "calculator_execute";
    }

    @PostConstruct
    public void init() {
        System.out.println("Calculator facade ready to use with " + allOperators.keySet() + " operators");
    }
}
