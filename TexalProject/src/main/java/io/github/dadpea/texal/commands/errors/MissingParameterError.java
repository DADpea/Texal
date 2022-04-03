package io.github.dadpea.texal.commands.errors;

import java.util.Arrays;
import java.util.StringJoiner;

public class MissingParameterError extends CommandError {
    String message;

    public MissingParameterError(String s, String... possible) {
        this.message = s + ". Possible values: ";
        StringJoiner joiner = new StringJoiner(", ");
        for (String s1 : possible) joiner.add(s1);
        this.message += joiner.toString();
    }
    public MissingParameterError(String s) {
        this.message = s + ".";
    }

    @Override
    protected String getErrorMessage() {
        return "Missing command parameter: " + this.message;
    }
}
