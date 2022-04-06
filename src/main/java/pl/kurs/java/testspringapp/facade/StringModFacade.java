package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.service.stringmod.Function;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StringModFacade {
    private final Map<String, Function> allFunctions;

    public StringModFacade(Set<Function> functions) {
        allFunctions = functions.stream().collect(Collectors.toMap(Function::getSymbol, java.util.function.Function.identity()));
    }

    public Set<String> getFunctionNames() {
        return allFunctions.keySet();
    }

    public StringModForm modifyForm(StringModForm form) {
        return allFunctions.get(form.getFunction()).modify(form);
    }
}
