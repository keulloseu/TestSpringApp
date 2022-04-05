package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.GraphFacade;
import pl.kurs.java.testspringapp.model.GraphForm;

@Controller
@RequiredArgsConstructor
public class GraphController {
    private final GraphFacade graphFacade;

    @GetMapping("/graph")
    public String graphStart(ModelMap map) {
        map.addAttribute("graphForm", new GraphForm());
        map.addAttribute("stats", graphFacade.getStatNames());
        return "graph";
    }

    @PostMapping("/graph/execute")
    public String graphExecute(ModelMap map, @ModelAttribute("graphForm") GraphForm form) {
        graphFacade.constructStatGraph(form);
        map.addAttribute("titleString", form.getTitle());
        map.addAttribute("surveyMap", form.getSurveyMap());
        map.addAttribute("yAxis", form.getYAxis());
        map.addAttribute("seriesName", form.getSeriesName());
        return "graph_execute";
    }
}
