package pl.kurs.java.testspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kurs.java.testspringapp.facade.GraphFacade;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.service.graph.Graph;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GraphController {
    private final GraphFacade graphFacade;

    @GetMapping("/graph")
    public String selectGraph(ModelMap map) {
        map.addAttribute("graphForm", new GraphForm());
        map.addAttribute("stats", graphFacade.getStatNames());
        return "graph";
    }

    @PostMapping("/graph/execute")
    public String graphExecute(ModelMap map, @ModelAttribute("graphForm") GraphForm graphForm) {
        graphFacade.createGraph(graphForm);
        map.addAttribute("titleString", graphForm.getTitle());
        map.addAttribute("surveyMap", graphForm.getSurveyMap());
        map.addAttribute("yAxis", graphForm.getYAxis());
        map.addAttribute("seriesName", graphForm.getSeriesName());
        return "graph_execute";
    }
}
