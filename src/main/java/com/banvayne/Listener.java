package com.banvayne;

import com.Config;
import com.command.CommandManager;
import me.duncte123.botcommons.BotCommons;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
public class Listener extends ListenerAdapter {
    Jokes joke = new Jokes();
    public final CommandManager manager=new CommandManager();

    private static final Logger LOGGER= LoggerFactory.getLogger(Listener.class);

    @Override
    public void onReady(@Nonnull ReadyEvent event){
       LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag() );
    }
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event){
        User user=event.getAuthor();

        if(user.isBot()||event.isWebhookMessage()){
            return;
        }

        String prefix= "/";
        String raw= event.getMessage().getContentRaw() ;
        if (raw.equalsIgnoreCase(prefix + "shutdown")
               ){
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("The bot will shutdown 😭").queue();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Here is a joke for the road").queue();
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(joke.pickRandomJoke()).queue();

            BotCommons.shutdown(event.getJDA());
            return;
        }
        if(raw.startsWith(prefix)){
            manager.handle(event,"/");
        }
    }


}
