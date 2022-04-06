package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.StringModFacade;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.service.CsvService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class StringModController {
    private final StringModFacade facade;
    private final CsvService csvService;

    @GetMapping("/stringmod")
    public String stringModStart(ModelMap map) {
        map.addAttribute("stringModForm", new StringModForm());
        map.addAttribute("functions", facade.getFunctionNames());
        return "stringmod";
    }

    @PostMapping("/stringmod/execute")
    public String stringModExecute(ModelMap map, @ModelAttribute StringModForm form) {
        map.addAttribute("modifiedString", facade.modifyForm(form).getModifiedString());
        return "stringmod_execute";
    }

    @GetMapping("/stringmod/download")
    public void stringModStart(HttpServletResponse servletResponse) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"stringMods.csv\"");
        try {
            csvService.writeDataToCsv(servletResponse.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
