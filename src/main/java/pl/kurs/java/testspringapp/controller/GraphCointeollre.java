package pl.kurs.java.testspringapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GraphCointeollre {
    @GetMapping("/graph")
    public String a(ModelMap map) {
        map.addAttribute("titleString", "dupa");
        map.addAttribute("surveyMap", Map.of("test1", 10, "test2", 20));
        map.addAttribute("yAxis", "chuj");
        map.addAttribute("seriesName", "cipa");
        return "graph_execute";
    }
}
