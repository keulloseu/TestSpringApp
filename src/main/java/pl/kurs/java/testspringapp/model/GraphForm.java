package pl.kurs.java.testspringapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphForm {
    private String title;
    private String yAxis;
    private String seriesName;
    private Map<String, Double> surveyMap;
}
