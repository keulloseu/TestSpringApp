package pl.kurs.java.testspringapp.service.graph;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringForm;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvgTimeGraphImpl implements Graph {
    @Override
    public void create(GraphForm graphForm, List<StringForm> usageList) {
        graphForm.setSurveyMap(usageList.stream()
                .collect(Collectors.groupingBy(StringForm::getFunction, Collectors.averagingLong(StringForm::getTime))));
        graphForm.setYAxis("Execution time [ns]");
        graphForm.setSeriesName("Time");
    }

    @Override
    public String getStatName() {
        return "Average execution time of all functions.";
    }
}
