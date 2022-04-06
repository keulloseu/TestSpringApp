package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.StringFacade;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;
import pl.kurs.java.testspringapp.service.CsvService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class StringController {
    private final StringRepo stringRepo;
    private final StringFacade stringFacade;
    private final CsvService csvService;

    @GetMapping(value = "/stringmod")
    public String stringMod(ModelMap map) {
        map.addAttribute("stringForm", new StringForm());
        map.addAttribute("modNames", stringFacade.getModNames());
        return "stringmod";
    }

    @PostMapping(value = "/stringmod/execute")
    public String stringModExecute(ModelMap map, @ModelAttribute("stringForm") StringForm stringForm) {
        StringForm modForm = stringFacade.modify(stringForm);
        map.addAttribute("modifiedString", modForm.getModStr());
        return "stringmod_execute";
    }

    @GetMapping("/stringmod/download")
    public void stringModDownload(HttpServletResponse servletResponse) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Concent-Disposition", "attachment; filename=\"stringMods.csv\"");
        try {
            csvService.writeDataToCsv(servletResponse.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
