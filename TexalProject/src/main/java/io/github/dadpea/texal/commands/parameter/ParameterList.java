package io.github.dadpea.texal.commands.parameter;

import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParameterList {
    private final ArrayList<Parameter<?>> params;

    public ParameterList() {
        this.params = new ArrayList<>();
    }

    public <T extends Parameter<?>> T add(T p) {
        this.params.add(p);
        return p;
    }

    public void testAgainst(String[] args) throws CommandError {
        for (int i = 0; i < params.size(); i++) {
            if (i >= args.length) {
                missingArgument(i);
            }
            params.get(i).checkValid(args, i);
        }
    }

    public List<String> tabComplete(String[] args) {
        int prm = args.length-1;
        if (prm >= params.size() || prm < 0) {
            return Collections.emptyList();
        } else {
            return params.get(prm).getSuggestions();
        }
    }

    private void missingArgument(int n) throws MissingParameterError {
        Parameter<?> p = params.get(n);
        throw new MissingParameterError("Missing a required parameter.");
    }
}
