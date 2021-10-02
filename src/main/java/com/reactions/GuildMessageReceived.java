package com.reactions;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {


        if (event.getReactionEmote().getName().equals("❌") &&
                !event.getMember().getUser().equals(event.getJDA().getSelfUser()) &&
                event.getMember().getUser().equals(event.retrieveMessage().complete().getAuthor())
        ) {
            try {
                event.getChannel().deleteMessageById(event.getMessageId()).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
