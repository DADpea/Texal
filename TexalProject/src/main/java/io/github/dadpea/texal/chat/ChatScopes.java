package io.github.dadpea.texal.chat;

public enum ChatScopes {
    GLOBAL(new ScopeGlobal()),
    LOCAL(new ScopeLocal()),
    NONE(new ScopeNone());

    final ChatScope scope;
    ChatScopes(ChatScope s) {
        this.scope = s;
    }

    public ChatScope getScope() {
        return scope;
    }
}
