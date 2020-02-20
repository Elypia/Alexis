/*
 * Copyright 2019-2020 Elypia CIC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elypia.alexis.controllers;

import org.elypia.commandler.api.Controller;

import javax.inject.Singleton;

//@Module(id = "Skills", group = "Settings", aliases = {"skill", "skills"}, help = "skills.h")
@Singleton
public class SkillsController implements Controller {

//    @Command(id = "skills.list", aliases = {"list", "show"}, help = "skills.list.h")
//    public Object list(@Channels(ChannelType.TEXT) JDACEvent event) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//
//        if (skills.isEmpty())
//            return scripts.get("skills.list.empty");
//
//        StringJoiner joiner = new StringJoiner("\n");
//
//        skills.forEach((skill) -> {
//            joiner.add(skill.getName());
//        });
//
//        EmbedBuilder builder = new EmbedBuilder();
//
//        builder.setTitle(scripts.get("skills"));
//        builder.setDescription(joiner.toString());
//
//        return builder;
//    }
//
//    @Command(id = "skills.info", aliases = "info", help = "skills.info.h")
//    @Param(id = "common.name", help = "skills.info.p.name.h")
//    public Object info(@Channels(ChannelType.TEXT) JDACEvent event, String name) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//        Optional<SkillEntry> optSkill = SkillEntry.getSkill(skills, name);
//
//        if (optSkill.isEmpty())
//            return scripts.get("skills.info.not_exist");
//
//        SkillEntry skill = optSkill.get();
//
//        EmbedBuilder builder = new EmbedBuilder();
//        builder.setTitle(skill.getName());
//        builder.setDescription(skill.getChannels().toString());
//        builder.setFooter(String.valueOf(skill.isEnabled()), null);
//        return builder;
//    }
//
//    @Command(id = "skills.create", aliases = {"create", "new"}, help = "skills.create.h")
//    @Param(id = "common.name", help = "skills.create.p.name.h")
//    public String create(@Channels(ChannelType.TEXT) JDACEvent event, String name) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//
//        if (skills.stream().anyMatch((skill) -> skill.getName().equalsIgnoreCase(name)))
//            return scripts.get("skills.create.skill_exists");
//
//        skills.add(new SkillEntry(name));
//        data.commit();
//
//        return scripts.get("skills.create.success");
//    }
//
//    @Command(id = "skills.delete", aliases = {"delete", "del", "remove"}, help = "skills.delete.h")
//    @Param(id = "common.name", help = "skills.delete.p.name.h")
//    public String delete(@Channels(ChannelType.TEXT) JDACEvent event, String name) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//        Optional<SkillEntry> optSkill = SkillEntry.getSkill(skills, name);
//
//        if (optSkill.isEmpty())
//            return scripts.get("skills.info.not_exist");
//
//        skills.remove(optSkill.get());
//        data.commit();
//        return scripts.get("skills.delete.success");
//    }
//
//    @Command(id = "skills.prune", aliases = "prune", help = "skills.prune")
//    public String prune(@Channels(ChannelType.TEXT) JDACEvent event) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//
//        if (skills.isEmpty())
//            return scripts.get("skills.list.empty");
//
//        skills.clear();
//        data.commit();
//
//        return scripts.get("skills.prune.success");
//    }
//
//    @Command(id = "skills.assign", aliases = "assign", help = "skills.assign.h")
//    @Param(id = "common.name", help = "skills.assign.p.name.h")
//    @Param(id = "common.channel", help = "skills.assign.p.channel.h")
//    public String assign(@Channels(ChannelType.TEXT) JDACEvent event, String name, @Search(Scope.LOCAL) TextChannel channel) {
//        GuildData data = GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//        List<SkillEntry> skills = data.getSettings().getSkills();
//        Optional<SkillEntry> optSkill = SkillEntry.getSkill(skills, name);
//
//        if (optSkill.isEmpty())
//            return scripts.get("skills.info.not_exist");
//
//        SkillEntry entry = optSkill.get();
//        entry.getChannels().add(channel.getIdLong());
//        data.commit();
//
//        return scripts.get("skills.assign.success");
//    }
//
//    @Command(id = "skills.notify", aliases = "notify", help = "skills.notify.h")
//    @Param(id = "common.name", help = "skills.notify.p.name.h")
//    @Param(id = "common.toggle", help = "skills.notify.p.toggle.h")
//    public String notify(@Channels(ChannelType.TEXT) JDACEvent event, String name, boolean enable) {
//        GuildData data = getGuildData(event);
//        List<SkillEntry> skills = data.getSettings().getSkills();
//        Optional<SkillEntry> optSkill = SkillEntry.getSkill(skills, name);
//
//        if (optSkill.isEmpty())
//            return scripts.get("skills.info.not_exist");
//
//        SkillEntry entry = optSkill.get();
//        var params = Map.of("enabled", enable);
//
//        if (entry.isNotify() == enable)
//            return scripts.get("skills.notify.same", params);
//
//        entry.setNotify(enable);
//        data.commit();
//
//        return scripts.get("skills.notify.success", params);
//    }
//
//    private GuildData getGuildData(JDACEvent event) {
//        return GuildData.query(event.asMessageRecieved().getGuild().getIdLong());
//    }
}