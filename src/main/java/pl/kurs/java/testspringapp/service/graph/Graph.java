package pl.kurs.java.testspringapp.service.graph;

import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringForm;

import java.util.List;

public interface Graph {
    void create(GraphForm graphForm, List<StringForm> usageList);

    String getStatName();
}
