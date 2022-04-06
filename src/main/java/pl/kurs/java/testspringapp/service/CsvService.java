package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kurs.java.testspringapp.model.StringForm;
import pl.kurs.java.testspringapp.model.StringRepo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {
    private final StringRepo stringRepo;

    public void writeDataToCsv(Writer writer) {
        List<StringForm> forms = stringRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (StringForm form : forms) {
                csvPrinter.printRecord(form.getId(), form.getStr(), form.getFunction(), form.getModStr(),
                        form.getTime(), form.getTimeOf());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
