package com.elypia.alexis.config.embedded;

import com.electronwill.nightconfig.core.conversion.*;

import java.util.List;

public class DiscordConfig {

    @Path("token")
    @SpecNotNull
    private String token;

    @Path("prefix")
    @SpecNotNull
    private String prefix;

    @Path("support_guild")
    private long supportGuild;

    public String getToken() {
        return token;
    }

    public String getPrefix() {
        return prefix;
    }

    public long getSupportGuild() {
        return supportGuild;
    }
}