package com.music;

import com.commands.CommandContext;
import com.commands.ICommand;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ClearQueueCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {

        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(ctx.getGuild());
        final TextChannel channel = ctx.getChannel();
        final Member self = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        final BlockingQueue<AudioTrack> queue = musicManager.scheduler.getQueue();

        final Member member = ctx.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in a voice channel ").queue();
            return;
        }

        if (ctx.getArgs().isEmpty()) {
            queue.clear();
            channel.sendMessage("the queue has been cleared").queue();
            return;
        }else{
            int count = Integer.parseInt(ctx.getArgs().get(0));
            for (int i=0; i<count;i++ ){

                queue.poll();
            }

        }


        channel.sendMessage("The player has been stopped and the queue has been cleared").queue();
    }

    @Override
    public String getName() {
        return "clearqueue";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("cq");
    }

    @Override
    public String getHelp() {
        return "clears the amount of songs that you specify\n. " +
                "If an amount is not specified it will clear the whole queue\n"
                + "Usage : /clearqueue <amount to delete>\n"
                + "Usage : /cq <amount to delete>";
    }
}
