package pl.kurs.java.testspringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.model.CalcForm;
import pl.kurs.java.testspringapp.model.CalcRepo;
import pl.kurs.java.testspringapp.service.CalcService;

@Controller
public class CalcController {

    @Autowired
    CalcService calcService;

    @Autowired
    @Qualifier("jdbcCalcRepository")
    CalcRepo calcRepo;

    @GetMapping(value = "/calculator")
    public String test(ModelMap map) {
        map.addAttribute("calcForm", new CalcForm());
        return "calculator";
    }

    @PostMapping(value = "/calculator/execute")
    public String execute(ModelMap map, @ModelAttribute("calcForm") CalcForm form) {
        form.setResult(calcService.calculateResult(form.getFirstArgument(), form.getSecondArgument(), form.getOperator()));
        calcRepo.save(form);
        map.addAttribute("firstArgument", form.getFirstArgument());
        map.addAttribute("secondArgument", form.getSecondArgument());
        map.addAttribute("operator", form.getOperator());
        map.addAttribute("result", form.getResult());
        return "calculator_execute";
    }

}
