package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.service.calculator.StringOperator;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringFacade {
    private Map<String, StringOperator> allOperators;

    public StringFacade(Set<StringOperator> operators){
        allOperators = operators.stream().collect(Collectors.toMap(StringOperator::getOperation, Function.identity()));
    }

    public Set<String> getOperation(){
        return allOperators.keySet();
    }

    public String getResult(StringForm stringForm){
        stringForm.setResult(allOperators.get(stringForm.getStringOperator()).convert(stringForm.getText()));
        return allOperators.get(stringForm.getStringOperator()).convert(stringForm.getText());
    }

    @PostConstruct
    public void init(){
        System.out.println("String facade is ready to use for following operations " + allOperators.keySet());
    }
}
