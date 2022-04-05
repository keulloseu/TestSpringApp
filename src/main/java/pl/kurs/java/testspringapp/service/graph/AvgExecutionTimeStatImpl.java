package pl.kurs.java.testspringapp.service.graph;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AvgExecutionTimeStatImpl implements Stat{

    @Override
    public void construct(GraphForm form, List<StringModForm> functionUsageList) {
        form.setSurveyMap(functionUsageList.stream()
                .collect(Collectors.groupingBy(StringModForm::getFunction, Collectors.averagingLong(StringModForm::getTime))));
        form.setYAxis("Execution Time [ns]");
        form.setSeriesName("Time");
    }

    @Override
    public String getStatName() {
        return "Average Execution Time of All Functions";
    }
}
