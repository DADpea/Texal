package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class StringParameter extends Parameter<String> {
    public StringParameter() {

    }
    public StringParameter(String def) {
        setValue(def);
    }

    @Override
    public void checkValid(String[] args, int pointer) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = pointer; i < args.length; i++) {
            joiner.add(args[i]);
        }
        setValue(joiner.toString());
    }

    @Override
    public List<String> getSuggestions() {
        return Collections.emptyList();
    }
}
