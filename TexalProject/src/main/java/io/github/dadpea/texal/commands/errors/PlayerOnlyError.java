package io.github.dadpea.texal.commands.errors;

public class PlayerOnlyError extends CommandError {

    @Override
    protected String getErrorMessage() {
        return "This command can only be run by players.";
    }
}
