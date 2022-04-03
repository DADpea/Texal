package io.github.dadpea.texal.commands.errors;

public class InternalError extends CommandError {
    @Override
    protected String getErrorMessage() {
        return "Internal error. Contact admins.";
    }
}
