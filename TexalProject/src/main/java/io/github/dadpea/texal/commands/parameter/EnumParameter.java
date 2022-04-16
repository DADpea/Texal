package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;

import java.util.ArrayList;
import java.util.List;

public class EnumParameter<E extends Enum<E>> extends Parameter<E> {
    private final Class<E> enumType;

    public EnumParameter(Class<E> type) {
        enumType = type;
    }
    public EnumParameter(Class<E> type, E def) {
        enumType = type;
        setValue(def);
    }

    @Override
    public void checkValid(String[] args, int pointer) throws InvalidParameterError {
        try {
            setValue(E.valueOf(enumType, args[pointer].toUpperCase()));
        } catch (Exception e) {
            throw new InvalidParameterError("Invalid type.");
        }
    }

    @Override
    public List<String> getSuggestions() {
        List<String> out = new ArrayList<>();
        for (E t : enumType.getEnumConstants()) {
            out.add(t.toString().toLowerCase());
        }
        return out;
    }
}
