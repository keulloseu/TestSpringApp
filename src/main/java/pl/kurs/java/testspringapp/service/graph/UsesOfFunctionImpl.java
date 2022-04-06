package pl.kurs.java.testspringapp.service.graph;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.GraphForm;
import pl.kurs.java.testspringapp.model.StringForm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsesOfFunctionImpl implements Graph {
    @Override
    public void create(GraphForm graphForm, List<StringForm> usageList) {
        graphForm.setSurveyMap(usageList.stream()
                .map(StringForm::getFunction).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().doubleValue())));
        graphForm.setYAxis("Total usages");
        graphForm.setSeriesName("Usages");
    }

    @Override
    public String getStatName() {
        return "Amount of usages of every funtion";
    }
}
