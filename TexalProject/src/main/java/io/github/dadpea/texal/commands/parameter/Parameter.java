package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;

import java.util.List;

public abstract class Parameter<T> {
    T out;
    public abstract void checkValid(String[] args, int pointer) throws InvalidParameterError;

    public abstract List<String> getSuggestions();

    public T getValue() {
        return this.out;
    }
    protected void setValue(T t) {
        this.out = t;
    }
}
