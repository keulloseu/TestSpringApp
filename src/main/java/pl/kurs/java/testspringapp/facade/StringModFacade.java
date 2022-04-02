package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.model.StringModRepo;
import pl.kurs.java.testspringapp.service.stringmod.Function;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StringModFacade {
    private final Map<String, Function> allFunctions;
    private final StringModRepo stringModRepo;

    public StringModFacade(Set<Function> functions, StringModRepo stringModRepo) {
        allFunctions = functions.stream().collect(Collectors.toMap(Function::getSymbol, java.util.function.Function.identity()));
        this.stringModRepo = stringModRepo;
    }

    public Set<String> getFunctionNames() {
        return allFunctions.keySet();
    }

    public StringModForm modifyForm(StringModForm form) {
        StringModForm modifiedForm = allFunctions.get(form.getFunction()).modify(form);
        stringModRepo.save(modifiedForm);
        return modifiedForm;
    }
}
