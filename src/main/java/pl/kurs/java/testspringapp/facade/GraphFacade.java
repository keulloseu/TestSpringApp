package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;
import pl.kurs.java.testspringapp.service.graph.Graph;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GraphFacade {
    private final Map<String, Graph> allStats;
    private final StringRepo stringRepo;

    public GraphFacade(Set<Graph> stats, StringRepo stringRepo) {
        this.allStats = stats.stream().collect(Collectors.toMap(Graph::getStatName, Function.identity()));
        this.stringRepo = stringRepo;
    }

    public Set<String> getStatNames() {
        return allStats.keySet();
    }

    public void createGraph(GraphForm graphForm) {
        allStats.get(graphForm.getTitle()).create(graphForm, stringRepo.findAll());
    }
}
