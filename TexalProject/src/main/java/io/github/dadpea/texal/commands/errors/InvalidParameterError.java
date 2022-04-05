package io.github.dadpea.texal.commands.errors;

import java.util.StringJoiner;

public class InvalidParameterError extends CommandError {
    String message;
    public InvalidParameterError(String s, String... possible) {
        this.message = s + ". Possible values: ";
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (String s1 : possible) joiner.add(s1);
        this.message += joiner.toString();
    }
    public InvalidParameterError(String s) {
        this.message = s + ".";
    }

    @Override
    protected String getErrorMessage() {
        return "Invalid parameter. " + this.message;
    }
}
