package pl.kurs.java.testspringapp.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;
import pl.kurs.java.testspringapp.model.StringModRepo;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {
    private final StringModRepo stringModRepo;

    public void writeDataToCsv(Writer writer) {
        List<StringModForm> forms = stringModRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (StringModForm form : forms) {
                csvPrinter.printRecord(form.getId(), form.getUserString(), form.getFunction(), form.getModifiedString(), form.getTime(), form.getTimeOf());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
