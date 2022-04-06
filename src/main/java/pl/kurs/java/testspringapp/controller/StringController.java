package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.CalcFacade;
import pl.kurs.java.testspringapp.facade.StringFacade;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;
import pl.kurs.java.testspringapp.service.CalcService;

@Controller
@RequiredArgsConstructor
public class StringController {
    private final StringRepo stringRepo;
    private final StringFacade stringFacade;

    @GetMapping(value = "/text")
    public String calculator(ModelMap map) {
        map.addAttribute("stringForm", new StringForm());
        map.addAttribute("modifiers", stringFacade.getOperation());
        return "string";
    }

    @PostMapping(value = "/text/execute")
    public String calculatorExecute(ModelMap map, @ModelAttribute("stringForm") StringForm stringForm) {
        if (stringForm.getText() == null) {
            return "string_redo";
        }
        stringFacade.getResult(stringForm);
        if (stringForm.getText() == null) {
            return "string_error";
        }
        stringRepo.save(stringForm); // wymaga zmiany
        map.addAttribute("result", stringFacade.getResult(stringForm));
        return "string_execute";
    }

}
