package com.elypia.alexis.config.embedded;

import com.electronwill.nightconfig.core.conversion.Path;

import java.util.List;

public class ApiCredentials {

    @Path("osu")
    private String osu;

    @Path("twitch")
    private String twitch;

    @Path("steam")
    private String steam;

    @Path("cleverbot")
    private String cleverbot;

    @Path("amazon")
    private AmazonCredentials amazonCredentials;

    public String getOsu() {
        return osu;
    }

    public String getTwitch() {
        return twitch;
    }

    public String getSteam() {
        return steam;
    }

    public String getCleverbot() {
        return cleverbot;
    }

    public List<AmazonCredentials> getAmazonCredentials() {
        return List.of(amazonCredentials);
    }
}