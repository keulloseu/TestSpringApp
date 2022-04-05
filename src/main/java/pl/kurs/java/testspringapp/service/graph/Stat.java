package pl.kurs.java.testspringapp.service.graph;

import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.List;

public interface Stat {

    void construct(GraphForm form, List<StringModForm> functionUsageList);

    String getStatName();
}
