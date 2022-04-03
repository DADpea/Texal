package io.github.dadpea.texal.commands.errors;

import io.github.dadpea.texal.style.Prefix;

public abstract class CommandError extends Exception {
    @Override
    public String toString() {
        return Prefix.PREFIX_FAILURE + this.getMessage();
    }

    abstract protected String getErrorMessage();
}
