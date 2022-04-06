package pl.kurs.java.testspringapp.facade;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringModRepo;
import pl.kurs.java.testspringapp.service.graph.Stat;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GraphFacade {
    private final Map<String, Stat> allStats;
    private final StringModRepo stringModRepo;

    public GraphFacade(Set<Stat> stats, StringModRepo stringModRepo) {
        this.allStats = stats.stream().collect(Collectors.toMap(Stat::getStatName, java.util.function.Function.identity()));
        this.stringModRepo = stringModRepo;
    }

    public Set<String> getStatNames() {
        return allStats.keySet();
    }

    public void constructStatGraph(GraphForm form) {
        allStats.get(form.getTitle()).construct(form, stringModRepo.findAll());
    }
}
