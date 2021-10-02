package com.banvayne;


import com.DMusician;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class Commands extends ListenerAdapter {
    Jokes joke = new Jokes();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(DMusician.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("(❁´◡`❁) VayneBot Information");
            info.setDescription("if(Vayne.getBanStatus()==false)\n lose");
            info.addField("Reason for living ","remind people to ban Vayne",false);
            info.addField("I can tell you a joke ","You need to write /joke in chat",false);

            info.setColor(Color.BLUE);
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();

        }
        if (args[0].equalsIgnoreCase(DMusician.prefix + "joke")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(joke.pickRandomJoke()).queue();
        }

    }
}
