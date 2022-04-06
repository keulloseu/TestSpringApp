package pl.kurs.java.testspringapp.service.graph;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AvgExecutionTimeStatImpl implements Stat {

    @Override
    public void construct(GraphForm form, List<StringModForm> functionUsageList) {
        form.setSurveyMap(Optional.ofNullable(functionUsageList)
                .filter(Predicate.not(List::isEmpty))
                .map(usageList -> usageList.stream()
                        .collect(Collectors.groupingBy(StringModForm::getFunction, Collectors.averagingLong(StringModForm::getTime))))
                .orElse(new HashMap<>()));
        form.setYAxis("Execution Time [ns]");
        form.setSeriesName("Time");
    }

    @Override
    public String getStatName() {
        return "Average Execution Time of All Functions";
    }
}
