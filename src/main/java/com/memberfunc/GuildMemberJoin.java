package com.memberfunc;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "Never gonna give [member] up. Never let [member] down!",
            "A wild [member] appeared.",
            "Brace yourselves. [member] just joined the server.",
            "It's dangerous to go alone, take [member]!",
            "We've been expecting you, [member]."

    };


    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        int index = (int)(Math.random() * messages.length);
        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[index].replace("[member]", event.getMember().getAsMention()));
        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

    }
}
