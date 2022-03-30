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
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;
import pl.kurs.java.testspringapp.service.CalcService;

@Controller
@RequiredArgsConstructor
public class CalcController {
    private final CalcService calcService;
    private final CalcRepo calcRepo;
    private final CalcFacade calcFacade;

    @GetMapping(value = "/calculator")
    public String calculator(ModelMap map) {
        map.addAttribute("calcForm", new CalcForm());
        map.addAttribute("operators", calcFacade.getOperatorSymbols());
        return "calculator";
    }

    @PostMapping(value = "/calculator/execute")
    public String calculatorExecute(ModelMap map, @ModelAttribute("calcForm") CalcForm form) {
        if (form.getFirstArgument() == null || form.getSecondArgument() == null) {
            return "calculator_redo";
        }
        calcService.calculateResult(form);
        if (form.getResult() == null) {
            return "calculator_error";
        }
        calcRepo.save(form);
        map.addAttribute("result", form.getResult());
        return "calculator_execute";
    }

}
