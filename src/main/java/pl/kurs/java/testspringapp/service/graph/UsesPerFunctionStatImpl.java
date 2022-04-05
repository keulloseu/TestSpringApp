package pl.kurs.java.testspringapp.service.graph;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsesPerFunctionStatImpl implements Stat{

    @Override
    public void construct(GraphForm form, List<StringModForm> functionUsageList) {
        form.setSurveyMap(functionUsageList.stream()
                .map(StringModForm::getFunction)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e -> e.getValue().doubleValue())));
        form.setYAxis("Total Usages");
        form.setSeriesName("Usages");
    }

    @Override
    public String getStatName() {
        return "The Total Amount of Usages of Every Function";
    }
}
