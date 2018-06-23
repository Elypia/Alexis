package com.elypia.alexis.handlers.modules;

import com.elypia.commandler.annotations.*;
import com.elypia.commandler.annotations.validation.command.Scope;
import com.elypia.commandler.events.MessageEvent;
import com.elypia.commandler.modules.CommandHandler;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;

import java.util.List;

@Module(name = "Emoticons", aliases = {"emote", "emoji", "emoticon"}, description = "Check all the emotes or how much they're being used.")
public class EmoteHandler extends CommandHandler {

    @Overload("list")
    @Command(name = "List all Emotes", aliases = "list", help = "List all of the custom emotes in this guild.")
    @Scope(ChannelType.TEXT)
    public void listEmotes(MessageEvent event) {
        listEmotes(event, event.getMessageEvent().getGuild());
    }

    @Overload("list")
    @Param(name = "guild", help = "The guild to get emotes from.")
    @Scope(ChannelType.PRIVATE)
    public String listEmotes(MessageEvent event, Guild guild) {
        List<Emote> emotes = guild.getEmotes();
        int count = emotes.size();

        if (count == 0)
            return "You don't actually have any emotes though... ^-^'";

        int length = (int)(Math.sqrt(count) + 1) * 2;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i % length == 0)
                builder.append("\n");

            builder.append(emotes.get(i).getAsMention());
        }

        return builder.toString();
    }

    @Overload("post")
    @Command(name = "Display Emote", aliases = {"get", "post"}, help = "Post an emote in the chat!")
    @Param(name = "emote", help = "A way to identify the emote you want to post.")
    public EmbedBuilder post(MessageEvent event, Emote emote) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setImage(emote.getImageUrl());
        return builder;
    }
}
