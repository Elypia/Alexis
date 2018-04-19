package com.elypia.alexis.discord.handlers.modules;

import com.elypia.commandler.CommandHandler;
import com.elypia.commandler.annotations.command.*;
import com.elypia.commandler.annotations.filter.Search;
import com.elypia.commandler.events.MessageEvent;
import com.elypia.commandler.jda.annotations.Scope;
import com.elypia.elypiai.utils.Markdown;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;

import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.elypia.alexis.utils.BotUtils.inviteUrl;
import static com.elypia.commandler.jda.data.SearchScope.LOCAL;

@Module(aliases = "User", help = "Get information or stats on global users! Try 'members' for guild specific commands.")
public class UserHandler extends CommandHandler {

	@CommandGroup("info")
	public void getInfo(MessageEvent event) {
		getInfo(event, event.getMessageEvent().getAuthor());
	}

	@CommandGroup("info")
	@Command(aliases = "info", help = "Get some basic information on the user!")
	@Param(name = "user", help = "The user to display information for.")
	@Scope(ChannelType.TEXT)
	public void getInfo(MessageEvent event, @Search(LOCAL) User user) {
		EmbedBuilder builder = new EmbedBuilder();
		String avatar = user.getEffectiveAvatarUrl();
		DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
		Guild guild = event.getMessageEvent().getGuild();
		Member member = guild.getMember(user);

		if (member != null) {
			builder.setAuthor(member.getEffectiveName());
			builder.addField("Online Status", member.getOnlineStatus().toString(), true);
			builder.addField("Status", member.getGame().getName(), true);
			builder.addField("Joined " + guild.getName(), member.getJoinDate().format(format), true);

			Collection<Role> roles = member.getRoles();

			if (!roles.isEmpty()) {
				StringJoiner joiner = new StringJoiner(", ");
				member.getRoles().forEach(o -> joiner.add(o.getName()));
				builder.addField("Roles", joiner.toString(), false);
			}
		} else {
			builder.setAuthor(user.getName());
		}

		builder.setThumbnail(avatar);
		builder.addField("Joined Discord", user.getCreationTime().format(format), true);

		if (user.isBot())
			builder.addField("Bot", Markdown.a("Invite link!", inviteUrl(user)), false);

		builder.setFooter("ID: " + user.getId(), null);

		event.reply(builder);
	}
}
