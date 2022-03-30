package pl.kurs.java.testspringapp.service;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.CalcForm;

@Service
public class CalcService {
    public CalcService() {
    }

    public void calculateResult(CalcForm form) {
        switch (form.getOperator()) {
            case "+":
                form.setResult(form.getFirstArgument() + form.getSecondArgument());
                break;
            case "-":
                form.setResult(form.getFirstArgument() - form.getSecondArgument());
                break;
            case "*":
                form.setResult(form.getFirstArgument() * form.getSecondArgument());
                break;
            case "/":
                if (form.getSecondArgument() == 0) {
                    form.setResult(null);
                    break;
                }
                form.setResult(form.getFirstArgument() / form.getSecondArgument());
                break;
            case "^":
                if (form.getFirstArgument() == 0 && form.getSecondArgument() == 0) {
                    form.setResult(null);
                    break;
                }
                form.setResult(Math.pow(form.getFirstArgument(), form.getSecondArgument()));
                break;
            case "root":
                if (form.getSecondArgument() == 0) {
                    form.setResult(null);
                    break;
                }
                form.setResult(Math.pow(form.getFirstArgument(), 1 / form.getSecondArgument()));
                break;
            default:
                form.setResult(null);
                break;
        }
    }
}
