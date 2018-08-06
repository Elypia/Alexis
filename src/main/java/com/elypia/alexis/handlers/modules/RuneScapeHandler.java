package com.elypia.alexis.handlers.modules;

import com.elypia.commandler.annotations.*;
import com.elypia.commandler.annotations.Module;
import com.elypia.commandler.jda.*;
import com.elypia.elypiai.runescape.RuneScape;

@Module(name = "RuneScape", aliases = {"runescape", "rs"}, help = "Integration with the popular MMORPG, RuneScape!")
public class RuneScapeHandler extends JDAHandler {

	private RuneScape runescape;

	public RuneScapeHandler() {
		runescape = new RuneScape();
	}

	@Command(name = "Status", aliases = "status", help = "The total number of created accounts.")
	public void displayStatus(JDACommand event) {

	}

	@Command(name = "Player Stats", aliases = "stats", help = "Get stats for a particular user.")
	@Param(name = "username", help = "RuneScape players username.")
	public void getPlayerStats(JDACommand event, String username) {

	}

//	@Command(name = "Player Quest Log", aliases = {"quests", "quest", "q"}, help = "Get status of all quests for a user.")
//	@Param(name = "username", help = "RuneScape players username.")
//	public void getQuests(AbstractEvent event, String username) {
//		runescape.getQuestStatuses(username, result -> {
//			EmbedBuilder builder = new EmbedBuilder();
//
//			Collection<QuestStats> completedQuests = result.getQuests(QuestStatus.COMPLETED);
//			Collection<QuestStats> startedQuests = result.getQuests(QuestStatus.STARTED);
//			Collection<QuestStats> notStartedQuests = result.getQuests(QuestStatus.NOT_STARTED);
//
//            String[] completed = ElyUtils.toStringArray(completedQuests);
//            String[] started = ElyUtils.toStringArray(startedQuests);
//			String[] notStarted = ElyUtils.toStringArray(notStartedQuests);
//
//			builder.setTitle("Quest Stats for " + result.getUsername() + "!");
//
//			builder.addField("Completed", String.join("\n", completed), false);
//			builder.addField("Started", String.join("\n", started), false);
//			builder.addField("Not Started", String.join("\n", notStarted), false);
//		}, failure -> BotUtils.sendHttpError(event, failure));
//	}
}
