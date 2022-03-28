package pl.kurs.java.testspringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.model.MyForm;
import pl.kurs.java.testspringapp.service.CalcService;
import pl.kurs.java.testspringapp.service.DbService;

@Controller
public class FirstController {

    @Autowired
    CalcService calcService;

    @Autowired
    DbService dbService;

    @GetMapping(value = "/calculate")
    public String calculate(ModelMap map) {
        map.addAttribute("myForm", new MyForm());
        return "calculate";
    }

    @PostMapping(value = "/calculate/execute")
    public String execute(ModelMap map, @ModelAttribute("myForm") MyForm myForm) {
        map.addAttribute("result", calcService.calcResult(myForm.getA(), myForm.getB(), myForm.getOperation()));
        dbService.saveToDatabase(myForm);
        map.addAttribute("a", myForm.getA());
        map.addAttribute("b", myForm.getB());
        map.addAttribute("operation", myForm.getOperation());
        map.addAttribute("result", myForm.getResult());
        return "calculate_execute";
    }
}
