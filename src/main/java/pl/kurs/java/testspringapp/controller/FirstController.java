package pl.kurs.java.testspringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.model.CalculationForm;
import pl.kurs.java.testspringapp.model.CalculationRepo;
import pl.kurs.java.testspringapp.service.CalculationService;

import java.sql.SQLException;

@Controller
public class FirstController {

    @Autowired
    CalculationService calculationService;

    @Autowired
    @Qualifier("jdbcCalculationRepo")
    CalculationRepo calculationRepo;

    @GetMapping("/calculation")
    public String calculation(ModelMap map) {
        map.addAttribute("calculation_form", new CalculationForm());
        return "calculation_start";
    }

    @PostMapping("/calculation/result")
    public String calculationResult(ModelMap map, @ModelAttribute("calculation_form") CalculationForm calculationForm) throws SQLException {
        map.addAttribute("result", calculationService.calculateOperation(calculationForm));
        calculationForm.setResult(calculationService.calculateOperation(calculationForm));
        calculationRepo.save(calculationForm);
        return "calculation_result";
    }
}
