package com.music.commands;

import com.commands.CommandContext;
import com.commands.ICommand;
import com.music.GuildMusicManager;
import com.music.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Collections;
import java.util.List;

public class PauseCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        final TextChannel channel = ctx.getChannel();
        final Member self = ctx.getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();

        if (!selfVoiceState.inVoiceChannel()) {
            channel.sendMessage("I need to be in a voice channel").queue();
            return;
        }

        final Member member = ctx.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        if (!memberVoiceState.inVoiceChannel()) {
            channel.sendMessage("You need to be in a voice channel ").queue();
            return;
        }

        if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())) {
            channel.sendMessage("You need to be in the same voice channel as me").queue();
            return;
        }

        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(ctx.getGuild());

        musicManager.scheduler.getPlayer().setPaused(!musicManager.scheduler.getPlayer().isPaused());


        channel.sendMessage("The player has been paused").queue();
    }

    @Override
    public String getName() {
        return "pause";
    }


    @Override
    public String getHelp() {
        return "pauses the music player or resumes";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("p");
    }
}
