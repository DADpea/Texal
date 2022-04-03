package io.github.dadpea.texal.commands.errors;

public class NoPermissionError extends CommandError {
    @Override
    protected String getErrorMessage() {
        return "You do not have permission to run this command.";
    }
}
