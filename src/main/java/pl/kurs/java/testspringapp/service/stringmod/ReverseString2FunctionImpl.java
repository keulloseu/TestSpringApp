package pl.kurs.java.testspringapp.service.stringmod;

import org.springframework.stereotype.Service;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.sql.Timestamp;

@Service
public class ReverseString2FunctionImpl implements Function {
    @Override
    public StringModForm modify(StringModForm form) {
        byte[] stringAsArray = form.getUserString().getBytes();
        byte[] result = new byte[stringAsArray.length];
        for (int i = 0; i < stringAsArray.length; i++) {
            result[i] = stringAsArray[stringAsArray.length - i - 1];
        }
        return new StringModForm(0, form.getUserString(), form.getFunction(), new String(result),
                0, new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String getSymbol() {
        return "reverse the text using byte array";
    }
}
