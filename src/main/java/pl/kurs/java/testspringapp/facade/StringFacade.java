package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;
import pl.kurs.java.testspringapp.service.stringCoder.ModStr;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringFacade {
    private final Map<String, ModStr> allMods;
    private final StringRepo stringRepo;

    public StringFacade(Set<ModStr> modStrs, StringRepo stringRepo) {
        allMods = modStrs.stream().collect(Collectors.toMap(ModStr::getMod, Function.identity()));
        this.stringRepo = stringRepo;
    }

    public Set<String> getModNames() {
        return allMods.keySet();
    }

    public StringForm modify(StringForm stringForm) {
        StringForm modStringForm = allMods.get(stringForm.getFunction()).modify(stringForm);
        stringRepo.save(modStringForm);
        return modStringForm;
    }
}
