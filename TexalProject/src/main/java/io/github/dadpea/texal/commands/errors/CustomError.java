package io.github.dadpea.texal.commands.errors;

public class CustomError extends CommandError{
    String s;

    public CustomError(String s) {
        this.s=s;
    }
    @Override
    protected String getErrorMessage() {
        return s;
    }
}
