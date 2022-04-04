package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.InvalidParameterError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class BooleanParameter extends Parameter<Boolean> {
    public BooleanParameter() {

    }
    public BooleanParameter(boolean def) {
        setValue(def);
    }

    @Override
    public void checkValid(String[] args, int pointer) throws InvalidParameterError {
        if (args[pointer].equalsIgnoreCase("false") || args[pointer].equalsIgnoreCase("f") || args[pointer].equals("0")) {
            setValue(false);
        } else if (args[pointer].equalsIgnoreCase("true") || args[pointer].equalsIgnoreCase("t") || args[pointer].equals("1")) {
            setValue(true);
        } else {
            throw new InvalidParameterError("Requires boolean. (True/False)");
        }
    }

    @Override
    public List<String> getSuggestions() {
        return Arrays.asList("true","false");
    }
}
