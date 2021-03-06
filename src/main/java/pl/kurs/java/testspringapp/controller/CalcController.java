package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.CalcFacade;
import pl.kurs.java.testspringapp.model.CalcForm;

@Controller
@RequiredArgsConstructor
public class CalcController {
    private final CalcFacade calcFacade;

    @GetMapping(value = "/calculator")
    public String calculator(ModelMap map) {
        map.addAttribute("calcForm", new CalcForm());
        map.addAttribute("operators", calcFacade.getOperatorSymbols());
        return "calculator";
    }

    @PostMapping(value = "/calculator/execute")
    public String calculatorExecute(ModelMap map, CalcForm form) {
        calcFacade.calculateResult(form);
        return calcFacade.redirect(map, form);
    }

}
