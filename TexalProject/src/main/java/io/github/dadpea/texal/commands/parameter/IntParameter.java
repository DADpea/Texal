package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntParameter extends Parameter<Integer> {
    public IntParameter() {

    }
    public IntParameter(int def) {
        setValue(def);
    }

    @Override
    public void checkValid(String[] args, int pointer) throws InvalidParameterError {
        try {
            setValue(Integer.parseInt(args[pointer]));
        } catch (Exception e) {
            throw new InvalidParameterError("Expected number.");
        }
    }

    @Override
    public List<String> getSuggestions() {
        return Collections.emptyList();
    }

}
